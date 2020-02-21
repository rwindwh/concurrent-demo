package cn.edu.cqvie.thread.ta.ta8;

import lombok.SneakyThrows;

public class Demo3 {

    private volatile int signal;

    @SneakyThrows
    public synchronized void set() {
        System.out.println("开始执行修改。。。");
        signal = 1;
        notifyAll(); //notify 随机唤醒一个处于wait的线程, notifyAll 唤醒所有处于wait的线程
        //唤醒线程之后休眠
        Thread.sleep(1000);
        System.out.println("状态值修改成功。。。");
    }

    @SneakyThrows
    public synchronized int get() {
        System.out.println(Thread.currentThread() + " 模拟代码开始进入。。。");
        if (signal != 1) {
            //wait 会释放锁
            wait();
        }
        System.out.println(Thread.currentThread() + " 模拟代码开始执行。。。");
        return signal;
    }

    public static void main(String[] args) throws InterruptedException {
        Demo3 demo3 = new Demo3();
        Target1 target1 = new Target1(demo3);
        Target2 target2 = new Target2(demo3);

        new Thread(target2).start();
        new Thread(target2).start();
        new Thread(target2).start();
        new Thread(target2).start();

        Thread.sleep(3000);

        new Thread(target1).start();

    }
}
