package array;

import java.util.HashMap;

public class LC55_JumpGame {

    HashMap<Integer, Boolean> cache = new HashMap();
    public boolean canJump(int[] nums) {
        return canJump(0, nums);
    }

    private boolean canJump(int index, int[] nums) {
        if (index >= nums.length - 1) {
            return true;
        }
        if (cache.containsKey(index)) return cache.get(index);
        int maxJump = nums[index];
        boolean result = false;
        for (int i = index + 1; i <= index + maxJump; i++) {
            result = canJump(i, nums);
            if (result) break;
        }
        cache.put(index, result);
        return result;

    }

}
