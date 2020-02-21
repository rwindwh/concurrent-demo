package cn.edu.cqvie.thread.tc.tc1;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        List s = new ArrayList();
        Collections.synchronizedList(s);

        Map m = new HashMap<>();
        Collections.synchronizedMap(m);


    }
}
