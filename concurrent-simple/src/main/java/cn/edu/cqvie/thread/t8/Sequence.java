package cn.edu.cqvie.thread.t8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自增序列演示线程安全问题
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Sequence {

    private static AtomicInteger value = new AtomicInteger(0);

    private int[] s = {1, 2, 3, 4, 5};
    private AtomicIntegerArray a = new AtomicIntegerArray(s);
    private AtomicReference<User> c = new AtomicReference<>();
    private AtomicIntegerFieldUpdater<User> id = AtomicIntegerFieldUpdater.newUpdater(User.class, "id");

    /**
     * synchronized 放在普通方法上，内置锁就是当前类的实例
     *
     * @return
     */
    public synchronized int getNext() {
        User user = new User();
        id.getAndIncrement(user);
        System.out.println(user.id);

        a.getAndIncrement(2);
        a.getAndAdd(2, 10);
        return value.getAndIncrement();
    }

    /**
     * 修饰静态方法，内置锁是当前Class字节码对象
     * Sequence.class
     *
     * @return
     */
    public static synchronized int getPrevious() {
        return value.getAndDecrement();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
//        while (true) {
//            System.out.println(sequence.getNext());
//        }
        for (int i = 0; i < 3; i++) {
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
