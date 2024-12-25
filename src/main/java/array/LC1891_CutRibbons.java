package array;

public class LC1891_CutRibbons {

    public int maxLength(int[] ribbons, int k) {
        int lo = 1;
        int hi = ((int) 1e6) + 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (possible(ribbons, k, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo - 1;
    }

    private boolean possible(int[] ribbons, int k, int num) {
        int count = 0;
        for (int r : ribbons) {
            count += (r / num);
            if (count >= k) return true;
        }
        return false;
    }
}
