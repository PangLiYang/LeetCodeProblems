package binary_tree_general;

public class Medium_114 {

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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode leftSide = root.left;
        TreeNode rightSide = root.right;

        root.left = null;
        root.right = leftSide;

        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = rightSide;
    }
}
