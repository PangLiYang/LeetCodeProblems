package binary_search_tree;

public class Medium_450_2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode rightLeftMin = root.right;
                TreeNode temp = root;
                while (rightLeftMin.left != null) {
                    temp = rightLeftMin;
                    rightLeftMin = rightLeftMin.left;
                }

                root.val = rightLeftMin.val;

                if (temp == root) {
                    temp.right = rightLeftMin.right;
                } else {
                    temp.left = rightLeftMin.right;
                }

                return root;
            }
        }
    }
}
