package bt_dfs;

import java.util.LinkedList;

public class Easy_236 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        LinkedList<TreeNode> listp = new LinkedList<>();
        LinkedList<TreeNode> listq = new LinkedList<>();
        TreeNode result = null;

        record(root, p, listp);
        record(root, q, listq);

        while (!listp.isEmpty() && !listq.isEmpty()) {
            TreeNode temp = listp.getFirst();
            if (listp.removeFirst() != listq.removeFirst()) {
                return result;
            }
            result = temp;
        }

        return result;
    }

    private boolean record (TreeNode node, TreeNode target, LinkedList<TreeNode> list) {
        if (node == null) {
            return false;
        }

        if (node == target) {
            list.addFirst(node);
            return true;
        }

        if (node.right == null && node.left == null) {
            return false;
        }

        if (node.right == null) {
            if (record(node.left, target, list)) {
                list.addFirst(node);
                return true;
            }
            return false;
        }

        if (node.left == null) {
            if (record(node.right, target, list)) {
                list.addFirst(node);
                return true;
            }
            return false;
        }

        if (record(node.left, target, list) || record(node.right, target, list)) {
            list.addFirst(node);
            return true;
        }

        return false;
    }
}
