package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
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
        System.out.println(zifu.substring(1));
        System.out.println(zifu.substring(0, zifu.length() - 1));
        System.out.println(Stream.of(zifu.split(",")).mapToInt(x -> Integer.valueOf(x)).boxed().collect(Collectors.toList()));
        System.out.println(Stream.of(zifu.split(",")).map(x -> Integer.valueOf(x)).collect(Collectors.toList()));


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(142);
        queue.add(102);
        queue.add(892);
        queue.add(8);
        queue.add(54);
        queue.add(234);
        queue.add(134);
        queue.add(34);
        queue.add(36);
        queue.add(30);
        queue.add(39);
        queue.add(39);
        queue.add(39);
        queue.add(35);
        queue.add(31);
        queue.add(37);
        queue.add(39);
        queue.add(39);
        System.out.println(queue);


    }
}
