package test;

/**
 * 2020-03-19 20:26
 */
public interface TISTest {

    default void pitName(){
        System.out.println("TISTest");
    }

    interface Ti {
        default void sayHello(){
            System.out.println("hello");
        }

        static String getHello(){
            return "getHello";
        }
    }
}
