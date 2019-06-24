package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-12 17:05
 * Description:
 */
public class LeanTest {

    public static void main(String[] args) {
        String binary = Long.toBinaryString(253402271999999L);
        System.out.println(binary);
        System.out.println(binary.length());


        System.out.println(Long.MAX_VALUE);
        System.out.println((Long.MAX_VALUE + "").length());
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        System.out.println(Long.toBinaryString(Long.MAX_VALUE).length());

        List<Integer> ss = new ArrayList<>();
        ss.add(1);
        ss.add(2);
        ss.add(3);

        System.out.println(ss.subList(0, 3));

        String ssd = "zhangsan";
        System.out.println(ssd.replace("san", "si"));
        System.out.println(ssd.substring(1));

        String key = "aa";
        char[] chars = key.toCharArray();
        System.out.println(chars);

        Character hc = '\0';
        System.out.println(hc.toString().getBytes());
    }

}
