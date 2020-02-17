package cn.edu.cqvie.thread.t1;

public class NewThread implements Runnable {

    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我自定义的线程执行了。。。。");
        }
    }

    public static void main(String[] args) {
        NewThread target = new NewThread();
        //初始化创建线程
        Thread thread = new Thread(target);
        //线程启动
        thread.start();

        while (true) {
            synchronized (target) {
                System.out.println("我主线程执行了。。。。");
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                target.notifyAll();
            }
        }
    }
}
