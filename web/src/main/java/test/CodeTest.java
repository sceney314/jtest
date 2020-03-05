package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);

        String zifu = "1,2,3,4,5";
        System.out.println(Stream.of(zifu.split(",")).mapToInt(x -> Integer.valueOf(x)).boxed().collect(Collectors.toList()));
        System.out.println(Stream.of(zifu.split(",")).map(x -> Integer.valueOf(x)).collect(Collectors.toList()));

    }
}