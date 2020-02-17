package cn.edu.cqvie.thread.t1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 启动类
 *
 * @author zhengsh
 * @date 2020-02-17
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(Config.class);
        DemoService demoService = ac.getBean(DemoService.class);
        demoService.a();
        demoService.b();
    }
}
