package cn.edu.cqvie.thread.t.t2;

import lombok.SneakyThrows;

public class Demo1 extends Thread {
    public Demo1(String name) {
        super(name);
    }

    @SneakyThrows
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(getName() + "线程运行了。。。");
            Thread.sleep(200);
        }
    }


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("thread-first");
        Demo1 demo2 = new Demo1("thread-second");

        demo1.start();
        demo2.start();

        demo1.interrupt();
        demo2.interrupt();
    }
}
