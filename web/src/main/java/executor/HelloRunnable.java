package executor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2020-03-05 14:25
 */
public class HelloRunnable implements Runnable{
    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()) + " hello world!");
    }
}
