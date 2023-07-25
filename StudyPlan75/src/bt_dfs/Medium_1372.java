package bt_dfs;

public class Medium_1372 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    int max;

    public int longestZigZag(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        max = 0;

        if (root.right == null) {
            dfs(root.left, 1, true);
            return max;
        }

        if (root.left == null) {
            dfs(root.right, 1, false);
            return max;
        }

        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return max;
    }

    private void dfs(TreeNode node, int count, boolean left) {
        if (node.left == null && node.right == null) {
            max = Math.max(max, count);
            return;
        }

        if (left) {
            if (node.right == null) {
                max = Math.max(max, count);
                dfs(node.left, 1, true);
                return;
            }

            if (node.left == null) {
                dfs(node.right, count + 1, false);
                return;
            }

            dfs(node.left, 1, true);
            dfs(node.right, count + 1, false);
            return;
        } else {
            if (node.right == null) {
                dfs(node.left, count + 1, true);
                return;
            }

            if (node.left == null) {
                max = Math.max(max, count);
                dfs(node.right, 1, false);
                return;
            }

            dfs(node.left, count + 1, true);
            dfs(node.right, 1, false);
            return;
        }
    }
}
