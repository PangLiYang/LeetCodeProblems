package bt_dfs;

public class Easy_236_2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.equals(p) || root.equals(q)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (right == null) {
            return left;
        } else if (left == null) {
            return right;
        } else {
            return root;
        }

    }
}
