package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC2832_MaxRange {

    public int[] maximumLengthOfRanges(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = right[i] - left[i] - 1;
        }
        return result;



    }

}
