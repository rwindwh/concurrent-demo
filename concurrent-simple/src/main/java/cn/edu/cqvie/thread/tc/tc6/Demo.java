package cn.edu.cqvie.thread.tc.tc6;

import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) {
        int nThread = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService =
                new ThreadPoolExecutor(nThread,
                        4, 8, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(16),
                        new ThreadFactory() {
                            int i = 0;

                            @Override
                            public Thread newThread(Runnable r) {
                                return new Thread(r, "pool-" + i++);
                            }
                        }, new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {

                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.isShutdown();
        while (executorService.isTerminated()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
