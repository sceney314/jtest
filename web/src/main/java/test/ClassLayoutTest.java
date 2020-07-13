package test;

import org.openjdk.jol.info.ClassLayout;

/**
 * 2020-07-03 07:21
 */
public class ClassLayoutTest {
    public static void main(String[] args) {
        int[] b = new int[1234567];
        b[0] = 0;
        System.out.println(ClassLayout.parseInstance(b).toPrintable());
        String a = "a";
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
        Integer c = 1;
        System.out.println(ClassLayout.parseInstance(c).toPrintable());

        System.out.println(384&255);
    }
}
