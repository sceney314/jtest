package test;

import java.util.concurrent.CountDownLatch;

/**
 * 2020-06-22 16:06
 */
public class CountDownLatchTest {

    private CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        CountDownLatchTest test = new CountDownLatchTest();

        test.pre();
        test.printA();
    }

    private void pre(){
        for (int i = 0; i < 5; i++){
            int finalI = i;
            (new Thread(() -> {
                System.out.println("开始准备" + finalI);
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开始！！！！" + finalI + "," + System.currentTimeMillis());
            })).start();
        }
    }

    private void printA(){
        (new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        })).start();
    }

}
