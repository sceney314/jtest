package guavalean;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 2020-06-11 07:56
 */
public class PermBucketTest {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(10.0);
        limiter.acquire();
    }
}
