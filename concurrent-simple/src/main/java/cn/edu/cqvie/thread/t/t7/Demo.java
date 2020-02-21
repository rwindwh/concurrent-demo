package cn.edu.cqvie.thread.t.t7;

import lombok.SneakyThrows;

/**
 * 保证可见性的前提
 * 多个线程拿到的是同一把锁
 *
 * @author zhengsh
 * @date 2020-02-18
 */
public class Demo {

    private volatile int a = 1;

    public synchronized int getA() {
        return a;
    }

    @SneakyThrows
    public synchronized void setA(int a) {
        Thread.sleep(10);
        this.a = a;
    }

    @SneakyThrows
    public static void main(String[] args) {

        Demo demo = new Demo();

        new Thread(() -> {
            demo.setA(10);
        }).start();

        new Thread(() -> {
            System.out.println(demo.getA());
        }).start();

        Thread.sleep(100);
        System.out.println(demo.getA());

    }
}
