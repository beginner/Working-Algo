package tree;

import java.util.ArrayList;
import java.util.List;

public class LC545_Boundary {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (!isLeaf(root)) {
            result.add(root.val);
        }
        leftBoundary(root, result);
        leaves(root, result);
        rightBoundary(root, result);
        return result;
    }

    private void leftBoundary(TreeNode node, List<Integer> list) {
        if (node == null) return;

        TreeNode left = node.left;
        while (left != null) {
            if (!isLeaf(left)) list.add(left.val);
            if (left.left != null) left = left.left;
            else left = left.right;
        }
    }

    private void rightBoundary(TreeNode node, List<Integer> list) {
        if (node == null) return;
        List<Integer> tmp = new ArrayList<>();

        TreeNode right = node.right;

        while (right != null) {
            if (!isLeaf(right)) tmp.add(right.val);
            if (right.right != null) right = right.right;
            else right = right.left;
        }

        for (int i = tmp.size() - 1; i >= 0; i--) {
            list.add(tmp.get(i));
        }
    }

    private void leaves(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (isLeaf(node)) list.add(node.val);
        leaves(node.left, list);
        leaves(node.right, list);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
