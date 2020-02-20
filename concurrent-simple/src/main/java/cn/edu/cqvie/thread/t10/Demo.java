package cn.edu.cqvie.thread.t10;

import lombok.SneakyThrows;

public class Demo {

    MyLock myLock = new MyLock();

    private void a() {
        myLock.lock();
        System.out.println("a");
        b();
        myLock.unlock();
    }

    public void b() {
        myLock.lock();
        System.out.println("b");
        myLock.unlock();
    }

    @SneakyThrows
    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(() -> {
            demo.a();
        }).start();
        Thread.sleep(10000);
    }
}
