package cn.edu.cqvie.thread.t3;

/**
 * 自增序列演示线程安全问题
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Sequence {

    private static int value;

    /**
     * synchronized 放在普通方法上，内置锁就是当前类的实例
     *
     * @return
     */
    public synchronized int getNext() {
        return value++;
    }

    /**
     * 修饰静态方法，内置锁是当前Class字节码对象
     * Sequence.class
     *
     * @return
     */
    public static synchronized int getPrevious() {
        return value--;
    }

    public int xx() {
        synchronized (Sequence.class) {
            if (value > 0) {
                return value;
            } else {
                return -1;
            }
        }
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
