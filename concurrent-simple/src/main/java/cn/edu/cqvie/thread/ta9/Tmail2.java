package cn.edu.cqvie.thread.ta9;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tmail2 extends Tmail {

    private volatile int count;
    public final int MAX_COUNT = 10;

    private Lock lock = new ReentrantLock();
    private Condition p = lock.newCondition();
    private Condition t = lock.newCondition();


    @SneakyThrows
    public void push() {
        lock.lock();
        while (count >= MAX_COUNT) {
            System.out.println(Thread.currentThread() + "库存数量达到上限，生产者停止生产");
            p.await();
        }
        count++;
        System.out.println(Thread.currentThread() + "生产者开始生产，当前库存为：" + count);
        t.signal();
        lock.unlock();
    }

    @SneakyThrows
    public void take() {
        lock.lock();
        while (count <= 0) {
            System.out.println(Thread.currentThread() + "库存数量为零，消费者等待");
            t.await();
        }
        count--;
        System.out.println(Thread.currentThread() + "生产者生产，当前库存：" + count);
        p.signal();
        lock.unlock();
    }
}
