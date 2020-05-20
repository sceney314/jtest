package test;


/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-12 17:05
 * Description:
 */
public class LeanTest {

    public static void main(String[] args) {
        System.out.println(SubClass.val);
//        SuperClass[] s = new SuperClass[10];
        Integer a = 3;
        Long b = 3L;
        if (b.equals(a)){
            System.out.println("a == b");
        }else{
            System.out.println("a != b");
        }
    }



}

class SuperClass{
    static {
        System.out.println("SuperClass init!");
    }

    public final static int val = 123;
}

class SubClass extends SuperClass{
    static {
        System.out.println("Subclass init");
    }

}