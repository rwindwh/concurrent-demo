package cn.edu.cqvie.thread.t2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * lambda 并行计算
 *
 * @author zhegnsh
 * @date 2020-02-17
 */
public class Demo7 {

    public int add(List<Integer> values) {
        //默认打印(并行导致无序)
        values.parallelStream().forEach(System.out::println);
        //顺序打印
        //values.parallelStream().forEachOrdered(System.out::println);
        return values.parallelStream().mapToInt(a -> a * 2).sum();
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10, 20, 30, 40);
        int res = new Demo7().add(values);
        System.out.println("计算结果: " + res);

        List<Object> l = new ArrayList<>();

        for (Integer i : values) {

        }
    }
}
