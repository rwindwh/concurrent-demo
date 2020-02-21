package cn.edu.cqvie.thread.tc.tc5;

import lombok.SneakyThrows;

public class PushTarget implements Runnable {

    private Shop tmail;

    public PushTarget(Shop tmail) {
        this.tmail = tmail;
    }


    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(1000);
            tmail.push();
        }
    }
}
