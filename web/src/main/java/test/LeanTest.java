package test;

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
    }

}
