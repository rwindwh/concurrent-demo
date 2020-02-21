package cn.edu.cqvie.thread.ta.ta7;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {

    public Map<String, Object> map = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    private Lock r = rwl.readLock();
    private Lock w = rwl.writeLock();

    private boolean isUpdate;

    public void readWrite() {
        r.lock();
        if (isUpdate) {
            r.unlock();
            w.lock();
            map.put("xxx", "xxx");
            r.lock();
            w.unlock();
        }

        Object obj = map.get("xxx");
        System.out.println(obj);
        r.unlock();
    }

    public Object get(String key) {
        try {
            r.lock();
            System.out.println(Thread.currentThread() + " 读操作在执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public void put(String key, String value) {
        try {
            w.lock();
            System.out.println(Thread.currentThread() + " 写操作在执行");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        } finally {
            w.unlock();
        }
    }


}
