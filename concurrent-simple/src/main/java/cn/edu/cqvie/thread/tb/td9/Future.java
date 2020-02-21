package cn.edu.cqvie.thread.tb.td9;

import lombok.SneakyThrows;

public class Future {

    private Product product;
    private boolean down;

    @SneakyThrows
    public synchronized Product getProduct() {
        if (!down) {
            wait();
        }
        return product;
    }

    public synchronized void setProduct(Product product) {
        while (down) {
            return;
        }
        this.product = product;
        this.down = true;
        notify();
    }
}
