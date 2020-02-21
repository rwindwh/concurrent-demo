package cn.edu.cqvie.thread.ta.ta8;

public class Demo {

    private volatile int signal;

    public void set(int signal) {
        this.signal = signal;
    }

    public int get() {
        return this.signal;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(() -> {
            System.out.println("开始执行修改。。。");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.set(1);
            System.out.println("状态值修改成功。。。");
        }).start();

        new Thread(() -> {
            System.out.println("模拟代码开始进入。。。");
            while (demo.get() != 1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("模拟代码开始执行。。。");
        }).start();
    }
}
