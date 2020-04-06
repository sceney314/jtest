package test;

import test.keywords.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2020-02-24 15:35
 */
public class CodeTest {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeSet<Integer> set = new TreeSet<>();

        TISTest tisTest = new TISTest(){};
        System.out.println(TISTest.Ti.getHello());

        Ice ice = new Ice();
        HashMap<String, String> sp = new HashMap<>();
        sp.put("1", "1");
        sp.put("2", "2");

        // 1111 1111 1111 111
        System.out.println((char)1);

        List<Integer> keys = string2List("").stream().map(Integer::new).collect(Collectors.toList());

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
        System.out.println(linkedList);

        String zifu = "1,2,3,4,5";
        System.out.println(zifu.substring(1));
        System.out.println(zifu.substring(0, zifu.length() - 1));
        System.out.println(Stream.of(zifu.split(",")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList()));
        System.out.println(Stream.of(zifu.split(",")).map(Integer::valueOf).collect(Collectors.toList()));

        List<Integer> shuzi = new ArrayList<>();
        shuzi.add(1);
        shuzi.add(4);
        shuzi.add(1, 2);
        shuzi.add(15, 5);
        System.out.println(shuzi);
    }

    public static List<String> string2List(String content){
        return string2List(content, ",");
    }

    public static List<String> string2List(String content, final String separator){
        if (content == null || content.trim().length() < 1){
            return new ArrayList<>();
        }
        return Arrays.stream(content.split(separator)).collect(Collectors.toList());
    }
}
