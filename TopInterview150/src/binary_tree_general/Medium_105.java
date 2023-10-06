package binary_tree_general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Medium_105 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int val = preorder[0];
        TreeNode root = new TreeNode(val);

        int idx;
        for (idx = 0; idx < inorder.length; idx += 1) {
            if (inorder[idx] == val) {
                break;
            }
        }

        int[] leftin = Arrays.copyOfRange(inorder, 0, idx);
        int[] rightin = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

        Set leftSet = new HashSet<>();
        Set rightSet = new HashSet<>();

        for (int i : leftin) {
            leftSet.add(i);
        }

        for (int i : rightin) {
            rightSet.add(i);
        }

        int[] leftpre = new int[leftin.length];
        int[] rightpre = new int[rightin.length];

        int lidx = 0;
        int ridx = 0;

        for (int i : preorder) {
            if (leftSet.contains(i)) {
                leftpre[lidx] = i;
                lidx += 1;
            } else if (rightSet.contains(i)) {
                rightpre[ridx] = i;
                ridx += 1;
            }
        }

        root.left = buildTree(leftpre, leftin);
        root.right = buildTree(rightpre, rightin);

        return root;
    }
}
