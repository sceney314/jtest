package test;


/**
 * 2019-12-23 09:57
 */
public class ALTest {

    public static void main(String[] args) {
        boolean r = true;
        int i = 100;
        while (i-- > 0){
            if ((System.currentTimeMillis() & 1) == 1){
                r = r && true;
            }else {
                r &= false;
                System.out.println("最终是false");
            }
        }
        System.out.println(r);
    }

}
