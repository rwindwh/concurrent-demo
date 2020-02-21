package cn.edu.cqvie.thread.tc.tc3;

public class Main {

    public static void main(String[] args) {
        Tmail tmail = new Tmail();

        PushTarget pushTarget = new PushTarget(tmail);
        TakeTarget takeTarget = new TakeTarget(tmail);

        new Thread(pushTarget).start();
        new Thread(takeTarget).start();
    }
}
