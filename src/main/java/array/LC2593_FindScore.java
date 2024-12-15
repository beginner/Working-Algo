package array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC2593_FindScore {

    public static void main(String[] args) {
        LC2593_FindScore problem = new LC2593_FindScore();
        int[] nums = {3};
        System.out.println(problem.findScore(nums));
    }

    public long findScore(int[] nums) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> {
            int result = Integer.compare(a.value, b.value);
            if (result != 0) return result;
            return Integer.compare(a.index, b.index);
        });
        Set<Integer> marked = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Cell cell = new Cell(nums[i], i);
            pq.offer(cell);
        }
        long sum = 0;

        while (marked.size() != nums.length) {
            while (pq.size() > 0 && marked.contains(pq.peek().index)) {
                pq.poll();
            }

            Cell cell = pq.poll();
            marked.add(cell.index);
            sum += cell.value;
            if (pq.isEmpty()) break;
            if (cell.index == 0) {
                marked.add(cell.index + 1);
            } else if (cell.index == nums.length - 1) {
                marked.add(cell.index - 1);
            } else {
                marked.add(cell.index - 1);
                marked.add(cell.index + 1);
            }

        }


        return sum;

    }

}

class Cell {
    int value;
    int index;
    public Cell(int v, int i) {
        value = v;
        index = i;
    }
}