package cn.edu.cqvie.thread.tb.td10;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo {

    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("正在计算结果。。。");
                Thread.sleep(1000);
                return 1;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(callable);
        Thread thread = new Thread(task);
        thread.start();

        // do something
        System.out.println("  干点别的 。。。。");
    }
}
