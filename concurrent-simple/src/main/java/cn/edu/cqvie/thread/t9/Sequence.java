package cn.edu.cqvie.thread.t9;

import cn.edu.cqvie.thread.t8.User;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自增序列演示线程安全问题
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Sequence {

    private int value;
    private Lock lock = new ReentrantLock();

    public int getNext() {
        try {
            lock.lock();
            return ++value;
        } finally {
            lock.unlock();
        }
    }

    public int getPrevious() {
        return --value;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " --> " + sequence.getNext());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
