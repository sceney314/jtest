package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * 2020-07-03 16:29
 */
public class StampedLockTest {
    private static volatile StampedLock lock = new StampedLock();
    public static void main(String[] args) {
        StampedLockTest test = new StampedLockTest();
        test.test3();
        System.out.println(Integer.toBinaryString(768));
    }

    private void test2() {
        long stmp = lock.writeLock();
        System.out.println("获取锁:" + stmp);
        lock.unlockWrite(stmp);
        System.out.println("释放锁成功");
    }

    private void test3() {
        for (int i = 1; i < 3; i++){
            final int k = i;
            Thread t = new Thread(() -> {
                System.out.println("线程 i:" + k + ", 准备抢锁");
                long stmp = lock.writeLock();
                System.out.println("线程 i:" + k + ", success");
                try {
                    int i1 = 5;
                    while (i1-- > 0){
                        Thread.sleep(1000);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                lock.unlockWrite(stmp);
            });
            t.start();
        }
    }

    private void test() {
        for (int i = 1; i < 6; i++) {
            final int k = i;
            Thread t = new Thread(() -> {
                int wr = 3;
                long stp = 0l;
                try {
                    if(k < wr){
                        System.out.println("线程：" + k + "，尝试获取{写}锁");
                        stp = lock.writeLock();
                        System.out.println("Success, 线程：" + k + "，获取「写」锁成功，stp=" + (stp & 255));
                    }else{
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("线程：" + k + "，尝试获取读锁");
                        stp = lock.readLock();
                        System.out.println("Success, 线程：" + k + "，获取读锁成功，stp=" + (stp & 255));
                    }

                    int km = 1000;
                    while (km-- > 0){
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(k < wr){
                        lock.unlockWrite(stp);
                    }else {
                        lock.unlockRead(stp);
                    }
                    System.out.println("release, 线程：" + k + "，释放读锁");
                }
            });
            t.start();
        }

    }
}
