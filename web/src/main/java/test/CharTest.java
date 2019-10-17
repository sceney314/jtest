package test;

import test.son.Man;
import test.son.People;
import test.son.Woman;

/**
 * @author zhengzp
 * 2019-10-15 20:08
 */
public class CharTest {
    public static void main(String[] args) {
        String con = "c001,C001003001,C001003001001001";
        System.out.println(con.toUpperCase().replace("C", "XC"));

        People p = new Man();

        if (p instanceof Man){
            System.out.println("男人");
        }else{
            System.out.println("不是男人");
        }

        if (!(p instanceof Woman)){
            System.out.println("不是女人");
        }else{
            System.out.println("女人");
        }
    }
}
