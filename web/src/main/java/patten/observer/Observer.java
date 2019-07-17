package patten.observer;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-19 14:16
 * Description:
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
