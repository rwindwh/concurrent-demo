package cn.edu.cqvie.thread.tb.td5;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    private int[] nums;

    public Demo(int line) {
        nums = new int[line];
    }

    public void calc(String line, int index) {
        String[] nums = line.split(",");
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }
        this.nums[index] = total;
        System.out.println(Thread.currentThread() + " 执行计算任务 。。。。" + line + " 结果为：" + total);
    }

    public void sum() {
        System.out.println("汇总线程开始执行。。。。");
        int total = 0;
        for (int i = 0; i < this.nums.length; i++) {
            total += this.nums[i];
        }
        System.out.println("最终的结果为。。。。" + total);
    }


    public static void main(String[] args) {
        List<String> list = readFile();
        int size = list.size();

        Demo demo = new Demo(size);
        for (int i = 0; i < size; i++) {
            final int j = i;
            new Thread(() -> {
                demo.calc(list.get(j), j);
            }).start();
        }

        while (Thread.activeCount() > 1) {}

        demo.sum();
    }

    @SneakyThrows
    public static List<String> readFile() {
        List<String> list = new ArrayList<>();
        String line = null;
        URL url = Demo.class.getClassLoader().getResource("nums.txt");
        assert url != null;
        FileReader in = new FileReader(url.getFile());
        BufferedReader br = new BufferedReader(in);
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        in.close();
        return list;
    }
}
