package cn.edu.cqvie.thread.t.t5;

/**
 * 单例懒汉模式(双重检查机制)
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Singleton2 {

    private volatile static Singleton2 instance;

    private Singleton2() {
    }

    /**
     * 双重检查加锁
     *
     * @return
     */
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                //双重检查加锁
                if (instance == null) {
                    //可能存在的指令重排序(需要设置 instance 被 volatile 修饰)
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
