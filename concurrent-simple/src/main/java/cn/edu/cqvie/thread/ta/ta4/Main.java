package cn.edu.cqvie.thread.ta.ta4;

import lombok.SneakyThrows;

public class Main {

    int value = 0;
    MyLock2 myLock2 = new MyLock2();

    public void a() {
        myLock2.lock();
        System.out.println("a");
        b();
        myLock2.unlock();
    }

    public void b() {
        myLock2.lock();
        System.out.println("b");
        myLock2.unlock();
    }

    @SneakyThrows
    public int next() {
        try {
            myLock2.lock();
            Thread.sleep(300);
            return value++;
        } finally {
            myLock2.unlock();
        }

    }

    public static void main(String[] args) {
        Main m = new Main();

        //测试可重入
        new Thread(() -> {
            m.a();
        }).start();

        //测试锁
        /*new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getId() + " " + m.next());
            }
        }).start();
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getId() + " " + m.next());
            }
        }).start();*/
    }
}
