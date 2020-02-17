package cn.edu.cqvie.thread.t6;

import lombok.SneakyThrows;

public class Demo3 {

    private Object obj1 = new Object();
    private Object obj2 = new Object();

    @SneakyThrows
    public void a() {
        synchronized (obj1) {
            Thread.sleep(10);
            synchronized (obj2) {
                System.out.println("Hello A");
            }
        }
    }

    @SneakyThrows
    public void b() {
        synchronized (obj2) {
            Thread.sleep(10);
            synchronized (obj1) {
                System.out.println("Hello B");
            }
        }
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();

        new Thread(demo3::a).start();

        new Thread(demo3::b).start();

        while (true) {
        }
    }
}
