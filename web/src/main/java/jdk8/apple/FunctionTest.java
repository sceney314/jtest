package jdk8.apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-06 10:06
 * Description:
 */
public class FunctionTest {

    public static <T, R> List<R> mapTest(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("green", 12));
        apples.add(new Apple("red", 2334));
        apples.add(new Apple("yellow", 45));
        apples.add(new Apple("while", 4345));
        apples.add(new Apple("blue", 645));

        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(apples);

        List<String> colors = mapTest(apples, Apple::getColor);
        System.out.println(colors);

        BiFunction<String, Integer, Apple> c3 = Apple::new;
        Apple apple = c3.apply("green", 110);
        System.out.println(apple);

    }
}
