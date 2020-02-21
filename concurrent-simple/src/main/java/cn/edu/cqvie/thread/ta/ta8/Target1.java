package cn.edu.cqvie.thread.ta.ta8;

public class Target1 implements Runnable {

    private Demo3 demo3;

    public Target1(Demo3 demo3) {
        this.demo3 = demo3;
    }

    @Override
    public void run() {
        demo3.set();
    }
}
