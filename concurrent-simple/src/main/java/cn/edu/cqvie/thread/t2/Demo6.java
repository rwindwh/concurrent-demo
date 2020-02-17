package cn.edu.cqvie.thread.t2;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 线程池
 *
 * @author zhegnsh
 * @date 2020-02-17
 */
public class Demo6 {

    public static void main(String[] args) {
        Executor threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
