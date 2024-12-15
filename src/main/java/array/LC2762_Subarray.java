package array;

import java.util.TreeMap;

public class LC2762_Subarray {

    public long continuousSubarrays(int[] nums) {
        long result = 0L;

        int len = nums.length;

        int left = 0;
        int right = 0;
        int max = nums[0];
        int min = nums[0];
        while (right < len) {
            max = Math.max(max, nums[right]);
            min = Math.min(min, nums[right]);

            while (max - min > 2) {
                left++;
                max = nums[left];
                min = nums[left];
                for (int k = left ; k <= right; k++) {
                    max = Math.max(max, nums[k]);
                    min = Math.min(min, nums[k]);
                }
            }
            result += right - left + 1;
            right++;

        }
        return result;
    }

    public long continuousSubarrays_optimized(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long result = 0;
        int right = 0;
        int left = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                int freq = map.get(nums[left]);
                if (freq == 1) map.remove(nums[left]);
                else map.put(nums[left], freq - 1);
                left++;
            }
            result += (right - left + 1);
            right++;
        }
        return result;

    }
}
