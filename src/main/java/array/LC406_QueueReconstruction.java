package array;

import java.util.Arrays;
import java.util.LinkedList;

public class LC406_QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            int result = Integer.compare(b[0], a[0]);
            if (result != 0) return result;
            return Integer.compare(a[1], b[1]);
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][0]);
    }

}
