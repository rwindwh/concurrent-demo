package cn.edu.cqvie.thread.tb.td6;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Demo {

    private Random random = new Random();

    @SneakyThrows
    public void meeting(CyclicBarrier cyclicBarrier) {
        Thread.sleep(random.nextInt(4000));
        System.out.println(Thread.currentThread().getName() + " 到达会议室，等待开会");
//        if (Thread.currentThread().getName().equals("Thread-1")) {
//            throw new RuntimeException();
//        }
        if (Thread.currentThread().getName().equals("Thread-1")) {
            //Thread.currentThread().interrupt();
            cyclicBarrier.reset();
        }
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("好！我们开始开会");
            }
        });

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                demo.meeting(barrier);
            }).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("等待线程数 " + barrier.getNumberWaiting());
            }
        }).start();
    }
}
