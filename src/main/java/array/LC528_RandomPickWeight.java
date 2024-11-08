package array;

// https://leetcode.com/problems/random-pick-with-weight/description
public class LC528_RandomPickWeight {

    int[] prefix;
    public LC528_RandomPickWeight(int[] w) {
        int len = w.length;
        prefix = new int[len];
        int prev = 0;
        for (int i = 0; i < len; i++) {
            prefix[i] = prev + w[i];
            prev = prefix[i];
        }
    }

    public int pickIndex() {
        int total = prefix[prefix.length - 1];
        double target = (Math.random() * total);
        return linear(target);
    }

    // O(N)
    private int linear(double target) {
        for (int i = 0; i < prefix.length; i++) {
            if (target < prefix[i]) return i;
        }
        return -1;
    }

    // O(logN)
    private int binarySearch(double target) {
        int lo = 0;
        int hi = prefix.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > prefix[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


}
