package array;

import java.util.Arrays;

public class LC2054_Overlapping {

    public int maxTwoEvents_TLE(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0],b[0]));
        int max = 0;

        for (int i = 0; i < events.length; i++) {
            int[] curr = events[i];
            max = Math.max(max, curr[2]);
            int index = binarySearch(events, curr[1]);
            for (int j = index; j < events.length; j++) {
                if (i == j) continue;
                int[] next = events[j];

                if (next[0] > curr[1]) {
                    max = Math.max(max, next[2] + curr[2]);
                }

            }
        }
        return max;
    }

    private int binarySearch(int[][] events, int num) {
        int lo = 0;
        int hi = events.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (events[mid][0] <= num) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}
