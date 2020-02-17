package cn.edu.cqvie.thread.t6;

import lombok.SneakyThrows;

public class Demo {

    @SneakyThrows
    public synchronized void a() {
        System.out.println("a");
        //b();
        Thread.sleep(1000);
    }

    @SneakyThrows
    public synchronized void b() {
        System.out.println("b");
        Thread.sleep(1000);
    }

    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();

        new Thread(() -> {
            d1.a();
        }).start();

        new Thread(() -> {
            d2.b();
        }).start();
    }
}
