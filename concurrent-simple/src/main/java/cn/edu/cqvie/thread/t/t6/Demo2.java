package cn.edu.cqvie.thread.t.t6;

import lombok.SneakyThrows;

import java.util.Random;

/**
 * 多个线程执行完毕后，打印一句话，结束
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行 。。。");
                Thread.sleep(new Random().nextInt(2000));
                System.out.println(Thread.currentThread().getName() + "线程完成执行 。。。");
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行 。。。");
                Thread.sleep(new Random().nextInt(2000));
                System.out.println(Thread.currentThread().getName() + "线程完成执行 。。。");
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行 。。。");
                Thread.sleep(new Random().nextInt(2000));
                System.out.println(Thread.currentThread().getName() + "线程完成执行 。。。");
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行 。。。");
                Thread.sleep(new Random().nextInt(2000));
                System.out.println(Thread.currentThread().getName() + "线程完成执行 。。。");
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行 。。。");
                Thread.sleep(new Random().nextInt(2000));
                System.out.println(Thread.currentThread().getName() + "线程完成执行 。。。");
            }
        }).start();

        //当前活动线程的数量
        int i = Thread.activeCount();

        while (i != 1) {
            //自旋
        }
        System.out.println("所有的线程执行完毕 。。。。");
    }
}
