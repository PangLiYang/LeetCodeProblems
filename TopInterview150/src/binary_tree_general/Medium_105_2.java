package binary_tree_general;

public class Medium_105_2 {

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

    private TreeNode buildHelper(int preS, int inS, int inE, int[] preorder, int[] inorder) {
        if (preS > preorder.length - 1 || inS > inE) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preS]);
        int iIdx = 0;
        for (int i = inS; i <= inE; i += 1) {
            if (inorder[i] == root.val) {
                iIdx = i;
                break;
            }
        }

        root.left = buildHelper(preS + 1, inS, iIdx - 1, preorder, inorder);
        root.right = buildHelper(preS + iIdx - inS + 1, iIdx + 1, inE, preorder, inorder);

        return root;
    }
}
