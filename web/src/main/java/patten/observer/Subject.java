package patten.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-19 14:16
 * Description:
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
