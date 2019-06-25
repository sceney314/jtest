package threadnotify;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-24 10:43
 * Description:
 */
public class RunTest {
    public static void main(String[] args) {
        try {
            Object lock = new Object();

            ThreadB b = new ThreadB(lock);
            b.start();

            ThreadC c = new ThreadC(lock);
            c.start();

//            ThreadA a = new ThreadA(lock);
//            a.start();
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
