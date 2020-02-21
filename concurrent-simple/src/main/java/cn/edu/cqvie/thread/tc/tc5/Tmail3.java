package cn.edu.cqvie.thread.tc.tc5;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Tmail3 implements Shop {

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(MAX_COUNT);

    @SneakyThrows
    @Override
    public void push() {
        queue.put(1);
    }

    @SneakyThrows
    @Override
    public void take() {
        queue.take();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
