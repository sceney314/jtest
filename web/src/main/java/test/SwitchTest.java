package test;

import java.util.LinkedList;
import java.util.Queue;

public class SwitchTest {
    public static void main(String[] args) {
//        String integerCacheHighPropValue = sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
//        int i = Integer.parseInt(integerCacheHighPropValue);
//        i = Math.max(i, 127);
//        System.out.println(i);

        Queue<Integer> tables = new LinkedList<>();
        tables.add(1);
        tables.add(5);
        tables.add(6);
        tables.add(7);
        System.out.println(tables.toString());
        System.out.println(tables);
    }
}
