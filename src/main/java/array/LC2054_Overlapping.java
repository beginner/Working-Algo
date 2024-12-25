package array;

import java.util.Arrays;
import java.util.PriorityQueue;

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


    public int maxTwoEvents(int[][] events) {
        int len = events.length;

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int[] suffix = new int[len];
        suffix[len - 1] = events[len-1][2];

        for (int i = len - 2; i >= 0; i--) {
            int[] e = events[i];
            suffix[i] = Math.max(suffix[i+1], e[2]);
        }
        int max = 0;

        for (int i = 0; i < len; i++) {
            int[] e = events[i];
            int index = binarySearch1(events, e[1], i + 1);
            if (index < events.length) {
                max = Math.max(max, e[2] + suffix[index]);
            } else {
                max = Math.max(max, e[2]);
            }
        }
        return max;

    }

    private int binarySearch1(int[][] events, int target, int lo) {
        int hi = events.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (events[mid][0] <= target) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        LC2054_Overlapping problem = new LC2054_Overlapping();
        int[][] events = {{1,3,2},{4,5,2},{1,5,5}};
        System.out.println(problem.maxTwoEvents(events));
    }

    public int maxTwoEvents_pq(int[][] events) {
        int len = events.length;

        Arrays.sort(events, (a, b) -> {
            int result = Integer.compare(a[0], b[0]);
            if (result != 0) return result;
            return Integer.compare(a[1], b[1]);
        });

        // {end time, value}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int max_seen = 0;
        int max = 0;

        for (int[] e : events) {
            int start = e[0];
            int end = e[1];
            int value = e[2];

            while (pq.size() > 0 && pq.peek()[0] < start) {
                max_seen = Math.max(max_seen, pq.poll()[1]);
            }
            max = Math.max(max, max_seen + value);
            pq.offer(new int[]{end, value});
        }

        return max;


    }

}
