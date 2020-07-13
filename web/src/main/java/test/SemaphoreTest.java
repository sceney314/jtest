package test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 2020-07-03 14:09
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        SemaphoreTest t = new SemaphoreTest();
        t.test();
    }

    private void test() {
        Semaphore phore = new Semaphore(4);
        for (int i = 1; i < 11; i++) {
            final int k = i;
            Thread t = new Thread(() -> {
                System.out.println("线程：" + k + "，尝试获取信号量");
                try {
                    phore.acquire();
                    System.out.println("Success, 线程：" + k + "，获取到信号量");
                    TimeUnit.SECONDS.sleep(2);
                    phore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }

    }
}
