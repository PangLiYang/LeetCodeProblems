package binary_search_tree;

public class Easy_530 {

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

    public int getMinimumDifference(TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        TreeNode[] prev = {null};

        inOrder(root, min, prev);

        return min[0];
    }

    private void inOrder(TreeNode root, int[] min, TreeNode[] prev) {

        if (root == null) {
            return;
        }

        inOrder(root.left, min, prev);

        if (prev[0] != null) {
            int curr = Math.abs(root.val - prev[0].val);
            min[0] = Math.min(min[0], curr);
        }
        prev[0] = root;

        inOrder(root.right, min, prev);

    }
}
