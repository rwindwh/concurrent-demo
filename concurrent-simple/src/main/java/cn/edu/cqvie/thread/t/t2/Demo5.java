package cn.edu.cqvie.thread.t.t2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务
 *
 * @author zhegnsh
 * @date 2020-02-17
 */
public class Demo5 {

    public static void main(String[] args) {
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                // 定时任务
                System.out.println("timer task is run");
            }
        }, 0, 1000);
    }
}
