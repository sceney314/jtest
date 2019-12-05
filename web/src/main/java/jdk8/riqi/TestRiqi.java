package jdk8.riqi;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestRiqi {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        calendar.add(Calendar.MONTH, 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(calendar.getTime()));

        System.out.println((int) Math.ceil(0.04));


        List<Integer> testInt = new ArrayList<>();
        testInt.add(1);
        testInt.add(2);
        testInt.add(4);

        List<Integer> newList = Collections.unmodifiableList(testInt);
        testInt.add(5);

        System.out.println("原list值：" + testInt);
        System.out.println("新list值：" + newList);
    }
}
