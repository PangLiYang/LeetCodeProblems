package binary_tree_general;

public class Easy_104 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode curr, int count) {
        if (curr == null) {
            return count;
        }

        return Math.max(dfs(curr.left, count + 1), dfs(curr.right, count + 1));
    }
}
