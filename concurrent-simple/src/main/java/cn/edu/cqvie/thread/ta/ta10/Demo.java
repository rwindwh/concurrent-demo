package cn.edu.cqvie.thread.ta.ta10;

import lombok.SneakyThrows;

public class Demo {

    private int signal;

    @SneakyThrows
    public synchronized void a() {
        while (signal != 0) {
            wait();
        }
        System.out.println("a");
        signal++;
        notifyAll();
    }

    @SneakyThrows
    public synchronized void b() {
        while (signal != 1) {
            wait();
        }
        System.out.println("b");
        signal++;
        notifyAll();
    }

    @SneakyThrows
    public synchronized void c() {
        while (signal != 2) {
            wait();
        }
        System.out.println("c");
        signal = 0;
        notifyAll();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        A a = new A(demo);
        B b = new B(demo);
        C c = new C(demo);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }
}

class A implements Runnable {

    private Demo demo;

    public A(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.a();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable {

    private Demo demo;

    public B(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.b();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class C implements Runnable {

    private Demo demo;

    public C(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.c();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}