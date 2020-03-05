package test;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

/**
 * 2020-02-24 15:35
 */
public class CodeTest {
    public static void main(String[] args) {
        int i = 3, j = 1;
        System.out.println(~i);
        System.out.println(Integer.toBinaryString(~i));
        System.out.println(Integer.toBinaryString(~i));
        System.out.println(i | j);
        System.out.println(i & j);
        System.out.println(i ^ j);

        System.out.println("--------");
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(-1 >>> 1);

    }
}
