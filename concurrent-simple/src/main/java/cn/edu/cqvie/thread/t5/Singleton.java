package cn.edu.cqvie.thread.t5;

/**
 * 单例饿汉模式
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Singleton {

    private Singleton() {
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
