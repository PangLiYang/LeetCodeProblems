package binary_tree_general;

import java.util.LinkedList;

public class Medium_222 {

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

    public int countNodes(TreeNode root) {
        int h = height(root);

        if (h < 0) {
            return 0;
        }

        if (height(root.right) == h -1) {
            return (int) Math.pow(2, h) + countNodes(root.right);
        } else {
            return (int) Math.pow(2, h - 1) + countNodes(root.left);
        }

    }

    private static int height(TreeNode node) {
        if (node == null) {
            return -1;
        }

        return 1 + height(node.left);
    }
}
