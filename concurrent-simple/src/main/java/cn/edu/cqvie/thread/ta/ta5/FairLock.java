package cn.edu.cqvie.thread.ta.ta5;

import java.util.ArrayList;
import java.util.List;

public class FairLock {

    private boolean isLock = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() {
        QueueObject queueObject = new QueueObject();
        boolean isLockForThisThread = true;
        synchronized (this) {
            waitingThreads.add(queueObject);
        }
        while (isLockForThisThread) {
            synchronized (this) {
                isLockForThisThread = isLock || waitingThreads.get(0) != queueObject;
                if (!isLockForThisThread) {
                    isLock = true;
                    waitingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try {
                queueObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreads.remove(queueObject);
                }
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            //new IllegalMonitorStateException("Call thread has not locked this lock");
            throw new RuntimeException("Call thread has not locked this lock");
        }
        isLock = false;
        lockingThread = null;
        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }
}
