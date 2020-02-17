package cn.edu.cqvie.thread.t5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadMain {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 2000; i++) {
            threadPool.execute(() -> {
                Singleton2 instance = Singleton2.getInstance();
                System.out.println(Thread.currentThread().getName() + ": " + instance);
            });
        }
    }
}
