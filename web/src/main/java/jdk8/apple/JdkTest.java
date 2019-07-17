package jdk8.apple;

import java.util.function.Function;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-06 16:14
 * Description:
 */
public class JdkTest {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 3;

        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> j = f.compose(g);
        int result = h.apply(1);
        System.out.println(result);
        System.out.println(j.apply(2));
    }
}
