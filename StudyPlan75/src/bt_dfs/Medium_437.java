package bt_dfs;

public class Medium_437 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private int count;

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;

        dfs(root, targetSum);

        return count;
    }

    private void dfs(TreeNode node, int targetSum) {

        if (node == null) {
            return;
        }

        if (node.val == targetSum) {
            count += 1;
        }

        if (node.left == null & node.right == null) {
            return;
        }

        if (node.left == null) {
            dfs(node.right, targetSum);
            dfsHelper(node.right, targetSum, node.val);
            return;
        }

        if (node.right == null) {
            dfs(node.left, targetSum);
            dfsHelper(node.left, targetSum, node.val);
            return;
        }

        dfs(node.right, targetSum);
        dfs(node.left, targetSum);
        dfsHelper(node.right, targetSum, node.val);
        dfsHelper(node.left, targetSum, node.val);
        return;
    }

    private void dfsHelper(TreeNode node, int targetSum, long sum) {

        if (node == null) {
            return;
        }

        sum += node.val;

        if (sum == targetSum) {
            count += 1;
        }

        if (node.left == null & node.right == null) {
            return;
        }

        if (node.left == null) {
            dfsHelper(node.right, targetSum, sum);
            return;
        }

        if (node.right == null) {
            dfsHelper(node.left, targetSum, sum);
            return;
        }

        dfsHelper(node.right, targetSum, sum);
        dfsHelper(node.left, targetSum, sum);
        return;
    }
}
