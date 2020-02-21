package cn.edu.cqvie.thread.tb.td9;

public class Demo {

    public static void main(String[] args) {
        //Product p = new Product(1, "蛋糕");
        ProductFactory factory = new ProductFactory();
        Future future = factory.createProduct("蛋糕");
        Product p = future.getProduct();

        System.out.println("我去上班，我下班了来拿蛋糕");
        System.out.println("我拿着蛋糕回家。。。" + p);
    }
}
