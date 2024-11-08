package tree;

public class LC426_ConvertBSTToDLL {

    TreeNode first = null, last = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        recurse(root);
        if (first != null) {
            first.left = last;
            last.right = first;
        }
        return first;
    }

    private void recurse(TreeNode node) {
        if (node == null) return;

        recurse(node.left);
        // node
        if (first == null) {
            first = node;
        }

        if (last != null) {
            last.right = node;
            node.left = last;
        }
        last = node;
        recurse(node.right);
    }

}
