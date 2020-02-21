package cn.edu.cqvie.thread.tb.td7;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Demo {

    @SneakyThrows
    public void method(Semaphore semaphore) {
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + " is run ...");
        Thread.sleep(2000);
        semaphore.release();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Semaphore semaphore = new Semaphore(10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            executorService.submit(() -> {
                demo.method(semaphore);
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
