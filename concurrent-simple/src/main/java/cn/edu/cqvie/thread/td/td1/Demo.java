package cn.edu.cqvie.thread.td.td1;

public class Demo {

    private int a;
    private int b;
    private int c;

    public void a() {
        a = 1;
        b = 2;
        c = a;
        b = c + a;
        System.out.println(b);
    }

    public static void main(String[] args) {
        new Demo().a();
    }
}
