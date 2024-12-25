package rate_limiters;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
    private final long _maxTokens; // Maximum capacity
    private final long _refillRate; // replenish rate per sec
    private final AtomicLong _currentTokens; // current number of tokens
    private final AtomicLong _lastRefillTimeNs; // last refill time in Ms

    public TokenBucket(long maxTokens, long refillRate) {
        _maxTokens = maxTokens;
        _refillRate = refillRate;
        _currentTokens = new AtomicLong(maxTokens);
        _lastRefillTimeNs = new AtomicLong(System.nanoTime());
    }

    public boolean tryConsume(int tokens) {

    }

    private void refill() {
        final long nowNs = System.nanoTime();
        final long elapsedNs = nowNs - _lastRefillTimeNs.get();
        if (elapsedNs > 0) {
            final long tokens = (elapsedNs * _refillRate) / (long)(10e9);
            if (tokens > 0) {
                final long newTokens = Math.min(_maxTokens, _currentTokens.get() + tokens);
                _currentTokens.set(newTokens);
                _lastRefillTimeNs.set(nowNs);
            }

        }
    }


}
