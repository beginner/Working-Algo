package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC230_KthSmallest {

    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return recurse(root, k).val;
    }

    private TreeNode recurse(TreeNode node, int k) {
        if (node == null) return null;

        TreeNode left = recurse(node.left, k);

        if (left != null) return left;

        count++;
        if (count == k) {
            return node;
        }
        return recurse(node.right, k);
    }

    public int kthSmallest_Iterative(TreeNode root, int k) {
        int count = 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (++count == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;

    }
}
