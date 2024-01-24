package binary_search_tree;

import java.util.LinkedList;
import java.util.List;

public class Medium_98 {

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

    public boolean isValidBST(TreeNode root) {
        return recCheck(root, null, null);
    }

    private boolean recCheck(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        int val = root.val;

        if (min != null && min >= val) {
            return false;
        }

        if (max != null && max <= val) {
            return false;
        }

        return recCheck(root.left, min, val) && recCheck(root.right, val, max);
    }
}
