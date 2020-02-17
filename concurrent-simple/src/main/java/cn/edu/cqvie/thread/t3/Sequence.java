package cn.edu.cqvie.thread.t3;

/**
 * 自增序列演示线程安全问题
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Sequence {

    private int value;

    /**
     * 通过增加同步块关键字
     *
     * @return
     */
    public synchronized int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
//        while (true) {
//            System.out.println(sequence.getNext());
//        }
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " --> " + sequence.getNext());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
