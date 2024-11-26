package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC102_BFS {

    // TC -> O(N)
    // SC -> O(N/2) --> O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (q.size() > 0) {
            int size = q.size();
            List<Integer> inner = new ArrayList<>();
            while (size-- > 0) {
                TreeNode poll = q.poll();
                inner.add(poll.val);
                if (poll.left != null) q.offer(poll.left);
                if (poll.right != null) q.offer(poll.right);
            }
            result.add(inner);
        }
        return result;
    }

}
