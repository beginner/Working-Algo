package rate_limiters;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Window is divided into smaller sub-windows for granular operations
 */
public class SlidingWindow {
    private final long _windowSizeMs;
    private final long _maxRequests;
    private final TreeMap<Long, Long> _requests;

    public SlidingWindow(long maxRequests, long windowSizeMs) {
        _maxRequests = maxRequests;
        _windowSizeMs  = windowSizeMs;
        _requests = new TreeMap<>();
    }

    public boolean tryConsume() {
        final long currentMs = System.currentTimeMillis();
        cleanUpOldEntries(currentMs);

        final long totalRequestsSoFar = _requests.values().stream()
                .mapToLong(l -> l)
                .sum();
        if (totalRequestsSoFar < _maxRequests) {
            _requests.put(currentMs, _requests.getOrDefault(currentMs, 0L) + 1);
            return true;
        }
        return false;
    }

    private void cleanUpOldEntries(final long currentMs) {
        _requests.headMap(currentMs - _windowSizeMs, true).clear();
    }


}
