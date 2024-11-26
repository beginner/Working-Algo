package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LC958_CompleteBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        return dfs(root);
    }

    // Same complexity as dfs
    private boolean bfs(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode prev = root;

        while (q.size() > 0) {
            TreeNode poll = q.poll();
            if (poll != null) {
                if (prev == null) return false;
                q.offer(poll.left);
                q.offer(poll.right);
            }
            prev = poll;
        }
        return true;
    }

    // TC -> O(n)
    // SC -> O(H) --> O(n) if skewed, otherwise O(logn)
    private boolean dfs(TreeNode root) {
        return dfs(root, 0, totalNodes(root));
    }

    private boolean dfs(TreeNode node, int index, int totalNodes) {
        if (node == null) return true;
        if (index >= totalNodes) return false;
        return dfs(node.left, 2 * index + 1, totalNodes)
                && dfs(node.right, 2 * index + 2, totalNodes);
    }

    private int totalNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + totalNodes(node.left) + totalNodes(node.right);
    }
}
