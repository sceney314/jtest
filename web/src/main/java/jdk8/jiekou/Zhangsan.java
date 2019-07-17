package jdk8.jiekou;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-17 11:12
 * Description:
 */
public class Zhangsan implements Man {
    @Override
    public int getAge() {
        return 12;
    }

    @Override
    public String sex() {
        return "男";
    }

    public static void main(String[] args) {
        People people = new Zhangsan();
        System.out.println(people.getAge());
        System.out.println(people.getName());
    }
}
