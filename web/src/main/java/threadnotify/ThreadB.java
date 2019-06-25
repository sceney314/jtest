package threadnotify;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-24 10:42
 * Description:
 */
public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    System.out.println("B thread 添加了" + (i + 1) + "个元素!");
                    if (MyList.size() % 2 == 1) {
                        lock.notify();
                        lock.wait();
                    }

                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
