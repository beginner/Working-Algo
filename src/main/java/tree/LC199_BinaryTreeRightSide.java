package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC199_BinaryTreeRightSide {


    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (i == size - 1) {
                    result.add(poll.val);
                }
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
        }
        return result;

    }

    // ---------------

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView_Recursive(TreeNode root) {
        recurse(0, root);
        return result;
    }


    private void recurse(int level, TreeNode node) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(node.val);
        }
        recurse(level + 1, node.right);
        recurse(level + 1, node.left);
    }


}
