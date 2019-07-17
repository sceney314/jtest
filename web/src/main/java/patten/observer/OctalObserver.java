package patten.observer;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-19 14:17
 * Description:
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }

}
