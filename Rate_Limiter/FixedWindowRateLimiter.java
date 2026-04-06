package Rate_Limiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements RateLimiter {

    private static class Window {
        long windowStart;
        AtomicInteger count;

        Window(long start) {
            this.windowStart = start;
            this.count = new AtomicInteger(0);
        }
    }

    private final RateLimitConfig config;
    private final ConcurrentHashMap<String, Window> store = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(RateLimitConfig config) {
        this.config = config;
    }

    @Override
    public boolean allowRequest(String key) {
        long currentTime = System.currentTimeMillis();

        store.putIfAbsent(key, new Window(currentTime));
        Window window = store.get(key);

        synchronized (window) {
            if (currentTime - window.windowStart >= config.getWindowSizeInMillis()) {
                window.windowStart = currentTime;
                window.count.set(0);
            }

            if (window.count.get() < config.getMaxRequests()) {
                window.count.incrementAndGet();
                return true;
            }

            return false;
        }
    }
}