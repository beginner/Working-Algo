package array;

import java.util.HashSet;
import java.util.Set;

public class LC3396_MinOperations {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,3,5,7};
        LC3396_MinOperations problem = new LC3396_MinOperations();
        System.out.println(problem.minimumOperations(nums));
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = nums.length - 1;
        while (i >= 0 && !set.contains(nums[i])) {
            set.add(nums[i]);
            i--;
        }
        int elementsToRemove = i + 1;

        return (int)( Math.ceil((double)elementsToRemove / 3));

    }

}
