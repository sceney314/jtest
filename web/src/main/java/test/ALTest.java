package test;

import test.son.People;

import java.util.ArrayList;

/**
 * @author zhengzp
 * 2019-12-23 09:57
 */
public class ALTest {

    public static void main(String[] args) {
//        Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//        System.out.println(DEFAULTCAPACITY_EMPTY_ELEMENTDATA.length);
        ArrayList<People> peoples = new ArrayList<>();
        peoples.add(new People("张三", 1));
        peoples.add(1, new People("王五", 2));
        peoples.contains(new People("李四", 3));

        System.out.println(peoples);

        int[] testInt = new int[]{1,2,3,4,5,6};
        System.arraycopy(testInt, 1, testInt, 0, testInt.length - 1);
        System.out.println(testInt);
    }

}
