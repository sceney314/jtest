package test;


import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * 2020-02-24 15:35
 */
public class CodeTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        map.put(1, "a");
        System.out.println(map);




        int HASH_BITS = 0x7fffffff;
        System.out.println(Integer.toBinaryString(HASH_BITS));
        System.out.println(Integer.toBinaryString(HASH_BITS).length());
        System.out.println(Integer.numberOfLeadingZeros(1));

        String s = "outerapi/billing/statistics/";
        System.out.println(s.length());

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.toString());


        Integer count = 0;
        final List<Integer> nums = new ArrayList<>();
        Callable<Integer> callable = Executors.callable(new Runnable() {
            @Override
            public void run() {
                System.out.println("我就是跑跑");
                nums.add(count);
            }
        }, count);

        try {
            System.out.println(callable.call());
        }catch (Exception e){
            e.printStackTrace();
        }


        int idx = 0;
        tset:
        for (;;){
            idx++;
            System.out.println("进来啦" + idx + ", " + System.currentTimeMillis());
            for (int i =0; ;i++){
                if (i > 100){
                    if (idx < 5){
                        continue tset;
                    }
                    break tset;
                }
            }
        }
        System.out.println("跳出来啦");
        System.out.println(Integer.toBinaryString(-1 << 29));
        System.out.println(-1 << 29);
    }


    public static List<String> string2List(String content) {
        return string2List(content, ",");
    }

    public static List<String> string2List(String content, final String separator) {
        if (content == null || content.trim().length() < 1) {
            return new ArrayList<>();
        }
        return Arrays.stream(content.split(separator)).collect(Collectors.toList());
    }


}



