package cn.edu.cqvie.thread.td.td2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {

    private Lock lock = new ReentrantLock();

    public void a() {
        lock.lock();
        System.out.println("... a ...");
        lock.unlock(); // 1 解锁
    }

    public void b() {
        lock.lock(); // 2 加锁
        System.out.println("... b ...");
        lock.unlock();
    }
}
