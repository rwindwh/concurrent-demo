package cn.edu.cqvie.thread.td.td3;

public class Demo {

    private int value;

    public synchronized void a() { //1 获取锁
        value++; //2
    } //3释放锁

    public synchronized void b() { //4 获取锁
        int a = value; //5
        //处理其他的操作
    } //6 释放锁
}
