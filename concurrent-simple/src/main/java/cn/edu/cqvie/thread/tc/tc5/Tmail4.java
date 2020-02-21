package cn.edu.cqvie.thread.tc.tc5;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Tmail4 implements Shop {

    private final int MAX_COUNT = 10;
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(MAX_COUNT);

    @SneakyThrows
    @Override
    public void push() {
        queue.put(1);
    }

    @Override
    public void take() {
        queue.remove();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
