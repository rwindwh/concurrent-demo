package cn.edu.cqvie.thread.tb.td3;

import lombok.SneakyThrows;

public class Demo {

    @SneakyThrows
    public void a(Thread joinThread) {
        System.out.println("方法a执行了。。。");
        joinThread.start();
        joinThread.join();
        System.out.println("方法a执行完毕。。。");
    }

    @SneakyThrows
    public void b() {
        System.out.println("加塞线程开始执行。。。");
        Thread.sleep(1000);
        System.out.println("加塞线程执行完毕。。。");
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        Thread t1 = new Thread(() -> {
           demo.b();
        });

        new Thread(() -> {
            demo.a(t1);
        }).start();
    }
}
