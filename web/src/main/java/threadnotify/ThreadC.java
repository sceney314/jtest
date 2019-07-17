package threadnotify;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-24 10:52
 * Description:
 */
public class ThreadC extends Thread {

    private Object lock;

    public ThreadC(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    System.out.println("C thread 添加了" + (i + 1) + "个元素!");
                    if (MyList.size() % 2 == 0) {
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
