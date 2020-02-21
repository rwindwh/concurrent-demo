package cn.edu.cqvie.thread.t.t2;

public class Demo3 {

    public static void main(String[] args) {
        /*new Thread() {
            @Override
            public void run() {
                System.out.println("thread start ...");
            }
        }.start();*/

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start ...");

            }
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("sub");
            }
        }.start();
    }
}
