package array;

import java.util.*;

// https://leetcode.com/problems/diagonal-traverse-ii/
// https://www.youtube.com/watch?v=5hG2nDEiwlE&t=751s
public class LC1424_DiagonalTraverse2 {


    // TC -> O(n); n is total number of elements
    // SC -> O(n); due to hashmao
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int total = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int row = nums.size() - 1;
        int min = 0, max = 0;

        while (row >= 0) {
            List<Integer> cells = nums.get(row);
            total += cells.size();
            for (int i = 0; i < cells.size(); i++) {
                int sum = row + i;
                min = Math.min(min, sum);
                max = Math.max(max, sum);
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(cells.get(i));
            }
            row--;
        }

        int[] result = new int[total];
        int write = 0;
        for (int i = min; i <= max; i++) {
            List<Integer> items = map.getOrDefault(i, new ArrayList<>());
            for (int item : items) {
                result[write++] = item;
            }
        }
        return result;
    }

    // TC -> O(n); n is total number of elements
    // SC -> O(sqrt(n)); max queue length for all the largest diagonal
    public int[] findDiagonalOrder_SpaceOptimized(List<List<Integer>> nums) {
        int total = 0;
        for (List<Integer> num : nums) {
            total += num.size();
        }
        int[] result = new int[total];
        int write = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        while (q.size() > 0) {
            int size = q.size();

            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            result[write++] = nums.get(x).get(y);

            if (y == 0 && x + 1 < nums.size()) {
                q.offer(new int[]{x + 1, y});
            }
            if (y + 1 < nums.get(x).size()) {
                q.offer(new int[]{x, y + 1});
            }
        }


        return result;
    }
}


