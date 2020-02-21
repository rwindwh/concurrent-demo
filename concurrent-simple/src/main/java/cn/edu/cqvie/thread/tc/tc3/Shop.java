package cn.edu.cqvie.thread.tc.tc3;

public interface Shop {

    int MAX_COUNT = 10;

    void push();

    void take();

    default int size() {
        return 0;
    }
}
