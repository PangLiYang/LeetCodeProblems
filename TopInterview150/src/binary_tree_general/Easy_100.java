package binary_tree_general;

public class Easy_100 {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }

        if (q == null && p != null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        if (p.val != q.val) {
            return false;
        }

        return (dfs(p.left, q.left) && dfs (p.right, q.right));
    }
}
