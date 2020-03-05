package executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 2020-03-05 14:24
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new HelloRunnable(), 1L, 1L, TimeUnit.SECONDS);
        while (true){
            try {
                Thread.sleep(5000L);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
