package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/nested-list-weight-sum
public class LC339_NestedListWeightedSum {

    public int depthSum(List<NestedInteger> nestedList) {
        // return recursive(nestedList, 1);
        return iterative(nestedList);
    }

    // Time -> O(N) -> total number of elements in nested list
    // Space -> O(N)
    private int recursive(List<NestedInteger> nestedList, int depth) {
        int total = 0;
        for (NestedInteger inner : nestedList) {
            if (inner.isInteger()) {
                total += (depth * inner.getInteger());
            } else {
                total += recursive(inner.getList(), depth + 1);
            }
        }
        return total;
    }

    // Time -> O(N)
    // Space -> O(N)
    private int iterative(List<NestedInteger> nestedList) {
        int depth = 1;
        Deque<NestedInteger> q = new ArrayDeque<>();
        q.addAll(nestedList);

        int total = 0;

        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                NestedInteger poll = q.poll();
                if (poll.isInteger()) {
                    total += poll.getInteger() * depth;
                } else {
                    q.addAll(poll.getList());
                }
            }

            depth++;
        }
        return total;
    }

}

class Pair {
    public NestedInteger ni;
    public int depth;
    public Pair(NestedInteger nestedInteger, int d) {
        this.ni = nestedInteger;
        this.depth = d;
    }
}

interface NestedInteger {
    public boolean isInteger();
    public List<NestedInteger> getList();
    public int getInteger();
}
