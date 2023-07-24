package DFS;

public class Medium_1488_2 {
    private int count = 0;

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        dfs(root, max);

        return count;
    }

    private void dfs(TreeNode node, int max) {
        if (node.val >= max) {
            max = node.val;
            count += 1;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left == null) {
            dfs(node.right, max);
            return;
        }

        if (node.right == null) {
            dfs(node.left, max);
            return;
        }

        dfs(node.right, max);
        dfs(node.left, max);

        return;
    }
}
