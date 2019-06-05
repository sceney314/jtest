package jdk8.apple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-05 17:55
 * Description:
 */
public class AppleTest {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        Apple apple1 = new Apple();
        apple1.setColor("green");
        apple1.setWeight(10);
        apples.add(apple1);

        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(200);
        apples.add(apple2);


        Apple apple3 = new Apple();
        apple3.setColor("red");
        apple3.setWeight(104);
        apples.add(apple3);


        Apple apple4 = new Apple();
        apple4.setColor("green");
        apple4.setWeight(1090);
        apples.add(apple4);


        Apple apple5 = new Apple();
        apple5.setColor("yellow");
        apple5.setWeight(809);
        apples.add(apple5);


        Apple apple6 = new Apple();
        apple6.setColor("yellow");
        apple6.setWeight(100);
        apples.add(apple6);


        Apple apple7 = new Apple();
        apple7.setColor("green");
        apple7.setWeight(80);
        apples.add(apple7);

        Apple apple8 = new Apple();
        apple8.setColor("red");
        apple8.setWeight(160);
        apples.add(apple8);
        List<Apple> greenApples = FilterApple.filterApples(apples, Apple::isGreenApple);
        System.out.println("greenApples:" + greenApples.toString());
        List<Apple> bigApples = FilterApple.filterApples(apples, Apple::isHeavyApple);
        System.out.println("bigApples:" + bigApples.toString());
        List<Apple> yellow = FilterApple.filterApples(apples, (Apple apple) -> apple.getColor().equals("yellow"));
        System.out.println("yellow:" + yellow.toString());

        List<Apple> tagetApple = apples.stream().filter((Apple a) -> a.getWeight() > 200).collect(Collectors.toList());
        System.out.println("tagetApple:" + tagetApple.toString());
    }
}
