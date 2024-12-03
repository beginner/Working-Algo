package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Eulerian path
// https://www.youtube.com/watch?v=8MpoO2zA2l4&t=415s

public class LC2097_ValidArrangement {

    int[][] result;
    public int[][] validArrangement(int[][] pairs) {
        backtrack(pairs, new ArrayList<>(), new HashSet<>());
        return result;
    }



    private void backtrack(int[][] pairs, List<int[]> curr, Set<Integer> visited) {
        if (result != null) return;
        if (curr.size() == pairs.length) {
            result = new int[curr.size()][2];
            for(int i = 0; i < curr.size(); i++) {
                result[i] = curr.get(i);
            }
            return;
        }

        for (int i = 0; i < pairs.length; i++) {
            int[] tmp = pairs[i];
            int s = curr.size();
            boolean valid = curr.isEmpty() || curr.get(s-1)[1] == tmp[0];
            if (valid && visited.add(i)) {
                curr.add(tmp);
                backtrack(pairs, curr, visited);
                curr.removeLast();
                visited.remove(i);
            }
        }



    }

}
