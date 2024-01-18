package binary_tree_general;

public class Hard_124 {

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

    public int maxPathSum(TreeNode root) {
        int[] globalMax = {Integer.MIN_VALUE};
        maxSumSupport(root, globalMax);
        return globalMax[0];
    }

    private int maxSumSupport(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(0, maxSumSupport(root.left, globalMax));
        int rightMax = Math.max(0, maxSumSupport(root.right, globalMax));

        int curr = root.val + leftMax + rightMax;
        globalMax[0] = Math.max(globalMax[0], curr);

        return root.val + Math.max(leftMax, rightMax);
    }
}
