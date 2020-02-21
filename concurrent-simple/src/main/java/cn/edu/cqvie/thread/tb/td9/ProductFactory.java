package cn.edu.cqvie.thread.tb.td9;

import java.util.Random;

public class ProductFactory {

    public Future createProduct(String name) {
        //订单
        Future f = new Future();

        new Thread(() -> {
            //产品
            Product p = new Product(new Random().nextInt(), name);
            f.setProduct(p);
        }).start();

        System.out.println("下单成功，你可以去上班了");

        return f;
    }
}
