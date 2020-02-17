package cn.edu.cqvie.thread.t5;

/**
 * 单例懒汉模式
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Singleton2 {

    private Singleton2() {
    }

    private static Singleton2 instance;

    /**
     * 偏向锁
     *
     * @return
     */
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
