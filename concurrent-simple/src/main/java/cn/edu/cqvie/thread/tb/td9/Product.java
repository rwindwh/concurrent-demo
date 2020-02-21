package cn.edu.cqvie.thread.tb.td9;

import lombok.SneakyThrows;

public class Product {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    @SneakyThrows
    public Product(int id, String name) {
        System.out.println("开始生产 " + name);
        Thread.sleep(4000);
        this.id = id;
        this.name = name;
        System.out.println(name + "上产完毕。。。");
    }
}
