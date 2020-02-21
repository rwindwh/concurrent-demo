package cn.edu.cqvie.thread.ta9;

import lombok.SneakyThrows;

public class TakeTarget implements Runnable {

    private Tmail tmail;

    public TakeTarget(Tmail tmail) {
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
