package tree;

public class LC297_SerializeDeserializerBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recurse(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void recurse(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        recurse(node.left, sb);
        recurse(node.right, sb);
    }


    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return build(tokens);
    }

    private TreeNode build(String[] tokens) {
        if (index >= tokens.length) return null;

        String t = tokens[index];
        if ("N".equals(t)) {
            index++;
            return null;
        }

        int val = Integer.parseInt(t);
        TreeNode node = new TreeNode(val);
        index++;
        node.left = build(tokens);
        node.right = build(tokens);
        return node;
    }
}
