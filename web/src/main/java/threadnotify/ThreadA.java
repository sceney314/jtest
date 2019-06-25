package threadnotify;

import java.time.LocalDateTime;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-24 10:35
 * Description:
 */
public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true){
                    System.out.println("current time " + LocalDateTime.now().toLocalDate() + " " + LocalDateTime.now().toLocalTime());
                    if (MyList.size() >= 10){
                        lock.notifyAll();
                        lock.wait();
                    }
                    Thread.sleep(1000);
                }
//                if (MyList.size() != 5) {
//                    System.out.println("wait begin " + LocalDateTime.now().toLocalDate() + " " + LocalDateTime.now().toLocalTime());
//                    lock.wait();
//                    System.out.println("wait end  " + LocalDateTime.now().toLocalDate() + " " + LocalDateTime.now().toLocalTime());
//                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
