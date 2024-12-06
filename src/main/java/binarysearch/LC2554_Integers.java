package binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC2554_Integers {

    public static void main(String[] args) {
        LC2554_Integers problem = new LC2554_Integers();
        int[] banned = {1,6,5};
        System.out.println(problem.maxCount_TwoPointer(banned, 5, 6));
    }

    public int maxCount_BinarySearch(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (found(banned, i)) continue;

            maxSum -= i;
            if (maxSum < 0) break;
            count++;
        }
        return count;

    }

    private boolean found(int[] banned, int target) {
        int lo = 0;
        int hi = banned.length - 1;

        while (lo <= hi) {
            int mid = ( lo + hi ) / 2;
            if (banned[mid] == target) return true;
            if (banned[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }

    // TC -> O(n + mlogm)
    public int maxCount_TwoPointer(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int j = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            while (j < banned.length && banned[j] == i) {
                found = true;
                j++;
            }
            if (found) continue;

            maxSum -= i;
            if (maxSum < 0) break;
            count++;
        }
        return count;
    }


    // TC -> O(M + N)
    // SC -> O(M)
    // M -> banned array
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int b : banned) {
            set.add(b);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;

            maxSum -= i;
            if (maxSum < 0) break;
            count++;
        }
        return count;
    }
}
