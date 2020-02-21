package cn.edu.cqvie.thread.tc.tc5;

import lombok.SneakyThrows;

public class TakeTarget implements Runnable {

    private Shop tmail;

    public TakeTarget(Shop tmail) {
        this.tmail = tmail;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(1000);
            tmail.take();
        }
    }
}
