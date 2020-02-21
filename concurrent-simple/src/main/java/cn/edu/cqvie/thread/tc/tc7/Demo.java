package cn.edu.cqvie.thread.tc.tc7;

import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) {
        //10个线程处理大量的任务

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(100, 100,0,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        while (true) {
            poolExecutor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  ");
                    Thread.sleep(1000);
                }
            });
        }


    }
}
