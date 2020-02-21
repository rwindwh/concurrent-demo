package cn.edu.cqvie.thread.tc.tc3;

public class Main3 {

    public static void main(String[] args) {
        Tmail3 tmail = new Tmail3();

        PushTarget pushTarget = new PushTarget(tmail);
        TakeTarget takeTarget = new TakeTarget(tmail);

        new Thread(pushTarget).start();
        new Thread(pushTarget).start();
        new Thread(pushTarget).start();

        new Thread(takeTarget).start();
        new Thread(takeTarget).start();

        new Thread(() -> {
            while (true) {
                System.out.println("size : " + tmail.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
