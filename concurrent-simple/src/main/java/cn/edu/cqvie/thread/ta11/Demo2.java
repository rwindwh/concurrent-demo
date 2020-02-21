package cn.edu.cqvie.thread.ta11;

import cn.edu.cqvie.thread.ta10.Demo;
import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {

    private int signal;
    private Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();


    @SneakyThrows
    public void a() {
        lock.lock();
        while (signal != 0) {
            a.await();
        }
        System.out.println("a");
        signal++;
        b.signal();
        lock.unlock();
    }

    @SneakyThrows
    public synchronized void b() {
        lock.lock();
        while (signal != 1) {
            b.await();
        }
        System.out.println("b");
        signal++;
        c.signal();
        lock.unlock();
    }

    @SneakyThrows
    public synchronized void c() {
        lock.lock();
        while (signal != 2) {
            c.await();
        }
        System.out.println("c");
        signal = 0;
        a.signal();
        lock.unlock();
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