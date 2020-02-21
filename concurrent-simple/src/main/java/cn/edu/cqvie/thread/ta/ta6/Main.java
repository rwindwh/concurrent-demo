package cn.edu.cqvie.thread.ta.ta6;

public class Main {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.put("a", "10");
        demo.put("b", "20");

        new Thread(() -> {
            demo.put("key1", "key1");
        }).start();

        new Thread(() -> {
            System.out.println(demo.get("key1"));
        }).start();
        new Thread(() -> {
            System.out.println(demo.get("key1"));
        }).start();
        new Thread(() -> {
            System.out.println(demo.get("key1"));
        }).start();
    }
}
