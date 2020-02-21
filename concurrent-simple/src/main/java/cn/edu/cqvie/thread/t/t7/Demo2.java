package cn.edu.cqvie.thread.t.t7;

import lombok.SneakyThrows;

public class Demo2 {

    public volatile boolean run = false;

    @SneakyThrows
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("执行了第 " + i + " 次");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            demo2.run = true;
        }).start();

        new Thread(() -> {
            while (!demo2.run) {
                //不执行
            }
            System.out.println("线程2执行了");
        }).start();

        Thread.sleep(10000);
    }
}
