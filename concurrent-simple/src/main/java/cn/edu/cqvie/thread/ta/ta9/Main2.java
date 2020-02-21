package cn.edu.cqvie.thread.ta.ta9;

public class Main2 {

    public static void main(String[] args) {
        Tmail2 tmail = new Tmail2();

        PushTarget pushTarget = new PushTarget(tmail);
        TakeTarget takeTarget = new TakeTarget(tmail);

        new Thread(pushTarget).start();
        new Thread(takeTarget).start();
    }
}
