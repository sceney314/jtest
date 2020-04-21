package test;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
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



