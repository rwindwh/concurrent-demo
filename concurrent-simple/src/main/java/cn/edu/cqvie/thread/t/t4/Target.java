package cn.edu.cqvie.thread.t.t4;

import lombok.SneakyThrows;

/**
 * 线程饥饿
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Target implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " ...");
            Thread.sleep(1);
        }
    }
}
