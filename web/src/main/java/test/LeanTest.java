package test;


import org.openjdk.jol.info.ClassLayout;

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
        int aa = 3;
        Long b = 3L;
        if (b.equals(a)){
            System.out.println("a == b");
        }else{
            System.out.println("a != b");
        }

        String s = new String("s");
        String ss = "s";

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("-------Integer");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println("-------int");
        System.out.println(ClassLayout.parseInstance(aa).toPrintable());
        System.out.println("-------Integer.class");
        System.out.println(ClassLayout.parseClass(Integer.class).toPrintable());
        System.out.println("-------String");
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
        System.out.println("-------char");
        System.out.println(ClassLayout.parseInstance('a').toPrintable());
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