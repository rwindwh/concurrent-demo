package cn.edu.cqvie.thread.ta9;

import lombok.SneakyThrows;

public class Tmail {

    private volatile int count;

    public final int MAX_COUNT = 10;

    @SneakyThrows
    public synchronized void push() {
        while (count >= MAX_COUNT) {
            System.out.println(Thread.currentThread() + "库存数量达到上限，生产者停止生产");
            wait();
        }
        count++;
        System.out.println(Thread.currentThread() + "生产者开始生产，当前库存为：" + count);
        notifyAll();
    }

    @SneakyThrows
    public synchronized void take() {
        while (count <= 0) {
            System.out.println(Thread.currentThread() + "库存数量为零，消费者等待");
            wait();
        }
        count--;
        System.out.println(Thread.currentThread() + "生产者生产，当前库存：" + count);
        notifyAll();
    }
}
