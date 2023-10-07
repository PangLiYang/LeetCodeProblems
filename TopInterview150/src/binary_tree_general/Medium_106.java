package binary_tree_general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Medium_106 {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildHelper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);

    }

    private TreeNode buildHelper(int postE, int inS, int inE, int[] inorder, int[] postorder) {
        if (postE > postorder.length - 1 || inS > inE) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postE]);

        int idx = 0;
        for (int i = 0; i < inorder.length; i += 1) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }

        root.right = buildHelper(postE - 1, idx + 1, inE, inorder, postorder);
        root.left = buildHelper(postE - inE + idx - 1, inS, idx - 1, inorder, postorder);

        return root;
    }
}
