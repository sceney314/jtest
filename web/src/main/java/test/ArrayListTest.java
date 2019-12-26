package test;

import test.son.People;

import java.util.ArrayList;

/**
 * Date: 2019-12-22 15:24
 * Copyright (C), 2015-2019
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<People> elems = new ArrayList<>();
        People p3 = new People("张三", 2);
        elems.add(p3);
        elems.add(new People("李四", 3));
        elems.add(new People("王五", 4));
        elems.add(new People("赵六", 5));


        // 返回的还是引用
        Object[] result = elems.toArray();
        People[] ps = new People[4];
        elems.toArray(ps);
        p3.setAge(23);
        System.out.println(ps);
        System.out.println(result);
    }

}
