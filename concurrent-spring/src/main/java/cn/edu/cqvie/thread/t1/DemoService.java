package cn.edu.cqvie.thread.t1;

import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @SneakyThrows
    @Async
    public void a() {
        while (true) {
            System.out.println("a");
            Thread.sleep(10);
        }
    }

    @SneakyThrows
    @Async
    public void b() {
        while (true) {
            System.out.println("b");
            Thread.sleep(10);
        }
    }
}
