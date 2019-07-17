package jdk8.apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-06 09:59
 * Description:
 */
public class ConsumerTest {

    public static <T> void forEachTest(List<T> list, Consumer<T> c){
        for (T t : list){
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        forEachTest(Arrays.asList(1,2,3,4,5, null), (Integer i) -> System.out.println(i));
    }
}
