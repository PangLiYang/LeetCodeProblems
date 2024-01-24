package binary_search_tree;

import java.util.LinkedList;
import java.util.List;

public class Medium_230 {

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

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new LinkedList<>();

        bs(root, k , list);

        return list.get(list.size() - 1);

    }

    private void bs(TreeNode root, int k, List<Integer> list) {

        if (root == null || list.size() == k) {
            return;
        }

        bs(root.left, k, list);

        if (list.size() == k) {
            return;
        }

        list.add(root.val);
        bs(root.right, k, list);
    }


}
