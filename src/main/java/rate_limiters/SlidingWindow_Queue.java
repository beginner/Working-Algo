package rate_limiters;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SlidingWindow_Queue {

    private BlockingQueue<Long> _requests;
    private final long _windowSizeMs;
    private final long _maxRequests;

    public SlidingWindow_Queue(final long windowSizeMs, final long maxRequests) {
        _maxRequests = maxRequests;
        _windowSizeMs = windowSizeMs;
    }

    public boolean tryConsume() {
        final long currentMs = System.currentTimeMillis();
        cleanupOldEntries(currentMs);

        if (_requests.size() < _maxRequests) {
            _requests.offer(currentMs);
            return true;
        }
        return false;
    }

    private void cleanupOldEntries(final long currentMs) {
        while (!_requests.isEmpty() && _requests.peek() <= currentMs - _windowSizeMs) {
            _requests.poll();
        }
    }

}
