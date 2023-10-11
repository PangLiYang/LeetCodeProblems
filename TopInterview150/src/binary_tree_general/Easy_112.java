package binary_tree_general;

public class Easy_112 {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        return dfs(root, targetSum, 0);

    }

    private boolean dfs(TreeNode root, int target, int sum) {

        sum += root.val;

        if (root.left == null && root.right == null) {
            if (sum == target) {
                return true;
            }
            return false;
        }

        if (root.right == null) {
            return dfs(root.left, target, sum);
        }

        if (root.left == null) {
            return dfs(root.right, target, sum);
        }

        return dfs(root.left, target, sum) || dfs(root.right, target, sum);
    }
}
