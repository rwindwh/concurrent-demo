package cn.edu.cqvie.thread.ta.ta12;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue<E> {

    private Object[] objects;
    private int addIndex;
    private int removeIndex;
    private int queueSize;
    private Lock lock = new ReentrantLock();
    Condition addCondition = lock.newCondition();
    Condition removeCondition = lock.newCondition();

    public MyQueue(int count) {
        objects = new Object[count];
    }

    @SneakyThrows
    public void add(E e) {
        lock.lock();
        while (queueSize == objects.length) {
            System.out.println(Thread.currentThread().getName() + " 队列为空，不进行移除");
            addCondition.await();
        }
        objects[addIndex] = e;
        if (++addIndex == objects.length) {
            addIndex = 0;
        }
        queueSize++;
        removeCondition.signal();
        lock.unlock();
    }

    @SneakyThrows
    public void remove() {
        lock.lock();
        while (queueSize == 0) {
            removeCondition.await();
        }
        objects[removeIndex] = null;
        if (++removeIndex == objects.length) {
            removeIndex = 0;
        }
        queueSize--;
        addCondition.signal();
        lock.unlock();
    }
}
