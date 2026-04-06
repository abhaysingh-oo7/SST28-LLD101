package Rate_Limiter;

import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter implements RateLimiter {

    private static class Counter {
        long windowStart;
        int currentCount;
        int previousCount;
    }

    private final RateLimitConfig config;
    private final ConcurrentHashMap<String, Counter> store = new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(RateLimitConfig config) {
        this.config = config;
    }

    @Override
    public boolean allowRequest(String key) {
        long now = System.currentTimeMillis();
        long windowSize = config.getWindowSizeInMillis();

        store.putIfAbsent(key, new Counter());
        Counter counter = store.get(key);

        synchronized (counter) {
            if (now - counter.windowStart >= windowSize) {
                counter.previousCount = counter.currentCount;
                counter.currentCount = 0;
                counter.windowStart = now;
            }

            double weight = (double)(windowSize - (now - counter.windowStart)) / windowSize;
            double effectiveCount = counter.previousCount * weight + counter.currentCount;

            if (effectiveCount < config.getMaxRequests()) {
                counter.currentCount++;
                return true;
            }

            return false;
        }
    }
}