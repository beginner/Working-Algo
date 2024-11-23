package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC128_LongestConsecutiveSequence {


    // TC -> O(nlogn)
    // SC -> O(logn) since Java uses a variant of Quick sort
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int max = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] - 1 == nums[i-1]) {
                    currentStreak++;
                } else {
                    max = Math.max(max, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(currentStreak, max);
    }

    // TC -> O(n)
    // SC -> O(n)
    public int longestConsecutive_TimeOptimized(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currentStreak = 1;
                int curr = n;
                while (set.contains(curr + 1)) {
                    currentStreak++;
                    curr++;
                }
                max = Math.max(max, currentStreak);
            }
        }
        return max;

    }
}
