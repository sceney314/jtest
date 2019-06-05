package jdk8.apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-05 17:55
 * Description:
 */
public class FilterApple {
    static List<Apple> filterApples(List<Apple> inventory, AppleFilter<Apple> p) {

        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
