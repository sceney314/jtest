package patten.observer;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-19 14:17
 * Description:
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }

}
