package bt_dfs;

public class Medium_1488 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return dfs(root, max, 0);
    }

    private int dfs(TreeNode node, int max, int count) {
        int add = 0;
        if (node.val >= max) {
            max = node.val;
            add += 1;
        }

        if (node.left == null && node.right == null) {
            return add;
        }

        if (node.left == null) {
            return dfs(node.right, max, count) + add;
        }

        if (node.right == null) {
            return dfs(node.left, max, count) + add;
        }

        return dfs(node.right, max, count) + dfs(node.left, max, count) + add;
    }
}
