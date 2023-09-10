package bt_dfs;

public class Medium_1372_2 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, 'L', 0);
        dfs(root.right, 'R', 0);

        return max;
    }

    private void dfs(TreeNode node, char c, int acc) {
        if (node == null) {
            max = Math.max(max, acc);
            return;
        }

        if (c == 'L') {
            dfs(node.right, 'R', acc + 1);
            dfs(node.left, 'L', 0);
        } else {
            dfs(node.left, 'L', acc + 1);
            dfs(node.right, 'R', 0);
        }

    }
}
