package cn.edu.cqvie.thread.tb.td8;

import lombok.SneakyThrows;

import java.util.concurrent.Exchanger;

public class Demo {

    @SneakyThrows
    public void a (Exchanger<String> exch) {
        System.out.println("a 方法执行 。。。");
        Thread.sleep(2000);
        String str = "12345";

        System.out.println("等待对比结果。。。");
        exch.exchange(str);
    }

    @SneakyThrows
    public void b(Exchanger<String> exch) {
        System.out.println("b 方法开始执行。。。");

        System.out.println("b 方法开始抓取数据。。。");
        Thread.sleep(4000);
        System.out.println("b 方法抓取数据结束。。。");

        String res = "12345";
        String value = exch.exchange(res);

        System.out.println("开始进行比对。。。");
        System.out.println("比对结果:" + value.equals(res));
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            demo.a(exchanger);
        }).start();
        new Thread(() -> {
            demo.b(exchanger);
        }).start();
    }
}
