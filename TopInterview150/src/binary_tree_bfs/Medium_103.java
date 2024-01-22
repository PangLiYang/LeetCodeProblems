package binary_tree_bfs;

import java.util.LinkedList;
import java.util.List;

public class Medium_103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new LinkedList<>();

        LinkedList<TreeNode> bfs = new LinkedList<>();

        if (root == null) {
            return output;
        }

        bfs.addLast(root);
        int dir = 1;

        while(!bfs.isEmpty()) {

            List<Integer> subList = new LinkedList<>();
            int currSize = bfs.size();

            for (int i = 0; i < currSize; i += 1) {
                TreeNode curr = bfs.removeFirst();

                if (dir == 1) {
                    subList.add(curr.val);
                } else {
                    subList.add(0, curr.val);
                }

                if (curr.left != null) {
                    bfs.addLast(curr.left);
                }
                if (curr.right != null) {
                    bfs.addLast(curr.right);
                }
            }

            output.add(subList);
            dir *= -1;
        }

        return output;
    }
}
