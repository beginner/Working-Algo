package array;

public class LC153_FindMinimum {

    // O(logN)
    public int findMin(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;

        int left = 0, right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[right - 1]) { // This is just optimization
                min = Math.min(min, nums[left]);
                break;
            }
            if (nums[mid] >= nums[left]) { // sorted
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid;

            }
        }
        return min;
    }
}
