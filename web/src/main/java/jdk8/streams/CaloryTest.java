package jdk8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-11 14:44
 * Description:
 */
public class CaloryTest {

    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("宫保鸡丁", 334, "川", 3, false));
        dishes.add(new Dish("口水鸡", 331, "粤",5, false));
        dishes.add(new Dish("土豆丝", 43, "鲁", 4, true));
        dishes.add(new Dish("西红柿炒蛋", 124, "鲁", 42, false));
        dishes.add(new Dish("土豆牛肉", 743, "鲁", 42, false));
        dishes.add(new Dish("水煮鱼", 543, "湘", 6, false));
        dishes.add(new Dish("辣椒鸡蛋", 164, "湘", 61, true));

        double avgCalories = dishes.stream().collect(Collectors.averagingInt(Dish::getCalory));
        System.out.println(avgCalories);

        int totalCalories = dishes.stream().collect(Collectors.summingInt(Dish::getCalory));
        System.out.println(totalCalories);
        Object a = dishes.stream().collect(Collectors.summarizingDouble(Dish::getCalory));
        System.out.println(a);
        Object lsm = dishes.stream().collect(Collectors.summarizingLong(Dish::getCalory));
        System.out.println(lsm);
        Object ism = dishes.stream().collect(Collectors.summarizingInt(Dish::getCalory));
        System.out.println(ism);

        String names = dishes.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(names);

        Map<String, List<Dish>> dishesByType = dishes.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        int total = dishes.stream().collect(Collectors.reducing(0, Dish::getCalory, Integer::sum));
        System.out.println(total);

        int tt = dishes.stream().map(Dish::getCalory).reduce(Integer::sum).get();
        System.out.println(tt);

        int cal = dishes.stream().mapToInt(Dish::getCalory).sum();
        System.out.println(cal);

        Map<String, Map<Integer, List<Dish>>> dishMap = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(Dish::getLevel)));
        System.out.println(dishMap);

        Map<String, Long> cmap = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(cmap);

        // 分组找到最大的卡路里
        Map<String, Dish> mostCaloricByType =
                dishes.stream().collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalory)), Optional::get)));
        System.out.println(mostCaloricByType);


        // 分区
        Map<Boolean, List<Dish>> area = dishes.stream().collect(Collectors.partitioningBy(Dish::getVegetarian));
        System.out.println(area);
        System.out.println(area.get(true));
        System.out.println(area.get(false));


        System.out.println(isPrime(7));
        System.out.println(partitionPrimes(8));
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }




}
