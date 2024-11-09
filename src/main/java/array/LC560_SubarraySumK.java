package array;

import java.util.HashMap;

public class LC560_SubarraySumK {

    // TC -> O(n)
    // SC -> O(n)
    // Basic idea is sum[i] - sum[j] = k
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int expected = sum - k;
            count += map.getOrDefault(expected, 0);
            int existing = map.getOrDefault(sum, 0);
            map.put(sum, existing + 1);
        }
        return count;
    }
}
