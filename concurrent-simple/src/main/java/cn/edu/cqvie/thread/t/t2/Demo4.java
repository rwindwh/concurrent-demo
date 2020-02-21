package cn.edu.cqvie.thread.t.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable
 *
 * @author zhegnsh
 * @date 2020-02-17
 */
public class Demo4 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("正在紧张执行中。。。。");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) throws Throwable {
        Demo4 demo4 = new Demo4();
        FutureTask<Integer> task = new FutureTask<>(demo4);
        Thread t = new Thread(task);
        t.start();

        System.out.println("先干点别的事情。。。");

        Integer result = task.get();
        System.out.println("线程执行的结果为：" + result);
    }
}
