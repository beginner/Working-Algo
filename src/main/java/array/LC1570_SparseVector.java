package array;

import java.util.HashMap;
import java.util.Map;

public class LC1570_SparseVector {

    HashMap<Integer, Integer> map = new HashMap<>();

    LC1570_SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(LC1570_SparseVector vec) {
        return helper(map, vec.map);
    }

    private int helper(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        if (a.size() > b.size()) return helper(b, a);
        int result = 0;
        for (var entry : a.entrySet()) {
            if (b.containsKey(entry.getKey())) {
                result += entry.getValue() * b.get(entry.getKey());
            }
        }
        return result;
    }

}
