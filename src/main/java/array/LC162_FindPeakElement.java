package array;

public class LC162_FindPeakElement {

    private int binarySearch(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) hi = mid - 1;
            else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid]) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

}
