package array;

public class MaxConsecutiveOnes {

    private int helper(int[] nums, int flips) {
        int left = 0;
        int max = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                flips--;
            }
            while (flips < 0) {
                flips += 1 - nums[left++];
            }
            max = Math.max(max, right - left + 1);

        }
        return max;
    }

}
