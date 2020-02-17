package cn.edu.cqvie.thread.t4;

/**
 * 线程饥饿
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Demo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Target());
        Thread t2 = new Thread(new Target());

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
