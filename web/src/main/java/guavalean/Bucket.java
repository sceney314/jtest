package guavalean;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 漏桶
 * <p>
 * 2020-06-11 14:58
 */
public class Bucket {

    private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<>();

    private final static int BUCKET_LIMIT = 1000;

    // 每秒处理 10 个
    private final RateLimiter consumerRate = RateLimiter.create(10d);

    // 往桶里放时确认没超过数量
    private Monitor offerMonitor = new Monitor();

    // 从桶里取数据时，桶里必须有数据
    private Monitor consumerMonitor = new Monitor();

    public static void main(String[] args) {

    }
}
