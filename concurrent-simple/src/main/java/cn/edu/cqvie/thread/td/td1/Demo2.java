package cn.edu.cqvie.thread.td.td1;

public class Demo2 {

    private int a;
    private boolean flag;

    public void writer() {
        //这个两个数据无依赖性，因此会对2行代码进行指令重排序
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int b = a + 1;
            System.out.println(b);
        }
    }
}
