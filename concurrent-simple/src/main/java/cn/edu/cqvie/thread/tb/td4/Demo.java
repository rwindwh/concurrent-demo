package cn.edu.cqvie.thread.tb.td4;

public class Demo {

    private ThreadLocal<Integer> count = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    public int getNext() {
        Integer value = count.get();
        value++;
        count.set(value);
        return value;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + demo.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + demo.getNext());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
