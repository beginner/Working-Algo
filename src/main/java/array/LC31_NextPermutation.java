package array;

public class LC31_NextPermutation {

    // Time -> O(n)
    // Space -> O(1)
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2 ;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i >= 0) {
            int j = len - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }
        reverse(nums, i+1, len - 1);

    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
