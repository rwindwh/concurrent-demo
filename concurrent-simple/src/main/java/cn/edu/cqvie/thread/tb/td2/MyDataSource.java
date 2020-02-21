package cn.edu.cqvie.thread.tb.td2;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

public class MyDataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int INIT_CONNECTIONS = 10;
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/abs_dev";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public MyDataSource() {
        for (int i = 0; i < INIT_CONNECTIONS; i++) {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            pool.addLast(con);
        }
    }

    @SneakyThrows
    public Connection getCollection() {
        Connection result = null;
        synchronized (pool) {
            while (pool.size() <= 0) {
                wait();
            }
            if (!pool.isEmpty()) {
                result = pool.removeFirst();
            }
        }
        return result;
    }

    public void release(Connection collection) {
        if (collection != null) {
            synchronized (pool) {
                pool.addLast(collection);
                notifyAll();
            }
        }
    }
}
