package dfs;

public class Easy_104 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int size) {
        if (node.left == null && node.right == null) {
            return size;
        }

        if (node.left == null) {
            return dfs(node.right, size + 1);
        }

        if (node.right == null) {
            return dfs(node.left, size + 1);
        }

        return Math.max(dfs(node.left, size + 1), dfs(node.right, size + 1));
    }
}
