package cn.edu.cqvie.thread.tb.td2;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDataSource2 {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int INIT_CONNECTIONS = 10;
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/abs_dev";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public MyDataSource2() {
        for (int i = 0; i < INIT_CONNECTIONS; i++) {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            pool.addLast(con);
        }
    }

    @SneakyThrows
    public Connection getCollection() {
        try {
            lock.lock();
            Connection result = null;
            while (pool.size() <= 0) {
                c1.await();
            }
            if (!pool.isEmpty()) {
                result = pool.removeFirst();
            }
            return result;
        } finally {
            lock.unlock();
        }
    }

    public void release(Connection collection) {
        if (collection != null) {
            try {
                lock.lock();
                pool.addLast(collection);
                c1.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
