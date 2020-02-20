package cn.edu.cqvie.thread.t10;

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
    private MyLock lock = new MyLock();

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
        for (int i = 0; i < 1; i++) {
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
