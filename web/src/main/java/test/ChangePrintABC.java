package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2020-06-22 15:22
 */
public class ChangePrintABC {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();


    public static void main(String[] args) {
        ChangePrintABC printABC = new ChangePrintABC();
        printABC.printA();
        printABC.printB();
        printABC.printC();
        lock.lock();
        try {
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    private void printA(){
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    try {
                        condition.await();
                        Thread.sleep(1000);
                        System.out.println("A");
                        condition.signal();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        });
        thread.start();
    }

    private void printC(){
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    try {
                        condition.await();
                        Thread.sleep(1000);
                        System.out.println("C");
                        condition.signal();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        });
        thread.start();
    }

    private void printB(){
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++){
                    try {
                        condition.await();
                        Thread.sleep(1000);
                        System.out.println("B");
                        condition.signal();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        });
        thread.start();
    }
}
