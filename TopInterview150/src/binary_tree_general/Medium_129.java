package binary_tree_general;

public class Medium_129 {

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

    private int rlSum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);

        return rlSum;

    }

    private void dfs(TreeNode root, int sum) {
        sum = 10 * sum + root.val;

        if (root.left == null && root.right == null) {
            rlSum += sum;
            return;
        }

        if (root.right == null) {
            dfs(root.left, sum);
            return;
        }

        if (root.left == null) {
            dfs(root.right, sum);
            return;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
