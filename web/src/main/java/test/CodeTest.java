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

        User user = new User();
        user.setName("张三");
        user.setSex("男");
        user.setAge(12);

        try {
            User u2 = (User)user.clone();
            u2.setName("李四");
            System.out.println(user);
            System.out.println(u2);
        }catch (Exception e){
            e.printStackTrace();
        }
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
