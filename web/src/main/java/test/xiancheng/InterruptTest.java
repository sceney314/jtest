package test.xiancheng;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 2020-04-28 19:04
 */
public class InterruptTest {
    public static void main(String[] args) throws Exception {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(1);
    }

}
