package patten.observer;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-19 14:18
 * Description:
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }

}
