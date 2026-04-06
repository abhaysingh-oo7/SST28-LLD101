package Rate_Limiter;

public class Main {

    public static void main(String[] args) {

        //Create config
        RateLimitConfig config = new RateLimitConfig(5, 60000); // 5 requests/min

        //Choose algorithm
        RateLimiter limiter = new SlidingWindowRateLimiter(config);
        //RateLimiter limiter = new FixedWindowRateLimiter(config);

        String tenant = "T1";

        //Simulate multiple requests
        for (int i = 1; i <= 10; i++) {
            boolean needsExternalCall = true; // assume always true for demo

            if (needsExternalCall) {
                if (limiter.allowRequest(tenant)) {
                    System.out.println("Request " + i + ": External call allowed");
                } else {
                    System.out.println("Request " + i + ": Rate limit exceeded ❌");
                }
            } else {
                System.out.println("Request " + i + ": No external call needed");
            }
        }
    }
}