package tree;

public class LC235_LCABST {


    // TC -> O(H) H = logN if balanced, otherwise N
    // SC -> O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;

        while (curr != null) {
            if (p.val > curr.val && q.val > curr.val) curr = curr.right;
            else if (p.val < curr.val && q.val < curr.val) curr = curr.left;
            else return curr;
        }
        return null;
    }

}
