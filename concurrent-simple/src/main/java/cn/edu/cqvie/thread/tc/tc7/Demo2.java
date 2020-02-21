package cn.edu.cqvie.thread.tc.tc7;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class Demo2 {

    public static void main(String[] args) {
        //10个线程处理大量的任务
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ThreadFactory threadFactory = new ThreadFactory() {
            int i = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "pool-" + i++);
            }
        };
        //ExecutorService pool = Executors.newCachedThreadPool();
        //ExecutorService pool = Executors.newSingleThreadExecutor();
        //ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        //ExecutorService pool = Executors.newWorkStealingPool();


        while (true) {

            Future<?> future = pool.submit(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  ");
                    Thread.sleep(1000);
                }
            });
            Object o = null;
            try {
                o = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(o);

//            pool.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }, 5, TimeUnit.SECONDS);

//            pool.execute(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "  ");
//                    Thread.sleep(1000);
//                }
//            });
        }

    }
}
