package test;

/**
 * @author zhengzp
 * 2019-08-05 16:09
 */
public class Test {

    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o){
            System.out.println(o);
        }
    }


}