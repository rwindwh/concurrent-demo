package cn.edu.cqvie.thread.t10;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {
    private AtomicBoolean isLock = new AtomicBoolean(false);

    private int lockCount = 0;
    private Thread lockBy;

    @Override
    public void lock() {
        synchronized (isLock) {
            Thread curr = Thread.currentThread();
            while (this.isLock.get() && curr != lockBy) {
                try {
                    isLock.wait();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.isLock.set(true);
            lockBy = curr;
            lockCount++;
        }
    }


    @Override
    public void unlock() {
        synchronized (isLock) {
            if (lockBy == Thread.currentThread()) {
                lockCount--;
                if (lockCount == 0) {
                    this.isLock.set(false);
                    this.isLock.notify();
                }
            }
        }
    }

    @Override
    public Condition newCondition() {

        return null;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
}
