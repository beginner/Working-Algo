package tree;

// https://www.youtube.com/watch?v=Hr5cWUld4vU
// https://leetcode.com/problems/binary-tree-maximum-path-sum
public class LC124_BinaryTreeMaximumPathSum {

    int max = 0;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = Math.max(dfs(node.left), 0);
        int r = Math.max(dfs(node.right), 0);
        max = Math.max(max, l + r + node.val);
        return Math.max(l + node.val, r + node.val);
    }

}
