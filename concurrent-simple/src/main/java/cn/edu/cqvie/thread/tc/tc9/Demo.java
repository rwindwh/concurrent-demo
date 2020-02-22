package cn.edu.cqvie.thread.tc.tc9;

import java.util.concurrent.locks.StampedLock;

public class Demo {

    private int balance;

    private StampedLock lock = new StampedLock();

     public void conditionReadWrite(int value) {
         long stamp = lock.readLock();
         while (balance > 0) {
             long writeStamp = lock.tryConvertToWriteLock(stamp);
             if (writeStamp != 0) { //成功转换为写锁
                 stamp = writeStamp;
                 balance += value;
             } else {
                 //没有转换成功为写锁，这里需要先释放读锁，然后再拿到写锁
                 lock.unlockRead(stamp);
                 //获取写锁
                 stamp = lock.writeLock();
             }
         }
         lock.unlock(stamp);
     }

    /**
     * 乐观锁去读取数据
     */
    public void optimisticRead() {
        long stamp = lock.tryOptimisticRead();
        int c = this.balance;
        //这里出现了写操作需要进行判断
        if (!lock.validate(c)) {
            //重新读取
            long l = lock.readLock();
            c = this.balance;
            stamp = l;
        }
        lock.unlockRead(stamp);
    }

    public void read() {
        long stamp = lock.readLock();
        int c = this.balance;
        lock.unlockRead(stamp);
    }

    public void write(int value) {
        long stamp = lock.writeLock();
        balance += value;
        lock.unlockWrite(stamp);
    }

    public static void main(String[] args) {


    }
}
