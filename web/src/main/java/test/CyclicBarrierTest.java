package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 2020-07-02 10:54
 */
public class CyclicBarrierTest {


    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.test();
    }

    private void test(){
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("都闪开，我要开始装逼了！！");
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        for (int i = 0; i < 5; i++){
            Worker worker = new Worker(i, barrier);
            Thread t = new Thread(worker);
            t.start();
            try {
                System.out.println(worker.toString());
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private class Worker implements Runnable{
        private int idx;

        CyclicBarrier barrier;

        Worker(int idx, CyclicBarrier barrier) {
            this.idx = idx;
            this.barrier = barrier;
        }

        @Override
        public String toString() {
            return "Worker [" + idx + "] 准备就绪!!!";
        }

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            for (int i = 5; i > 0; i--){
                try {
                    System.out.println(System.currentTimeMillis() + ", 线程=" + idx + ", 批次=" + i);
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
