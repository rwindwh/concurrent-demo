package cn.edu.cqvie.thread.tc.tc8;

public class Demo {
    public static void main(String[] args) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("runable……");

                }
            }) {
                @Override
                public void run() {
                    System.out.println("test");
                    super.run();
                }
            }.start();

    }
}
