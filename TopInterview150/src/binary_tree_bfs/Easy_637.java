package binary_tree_bfs;

import java.util.LinkedList;
import java.util.List;

public class Easy_637 {

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new LinkedList<>();

        LinkedList<TreeNode> bfs = new LinkedList<>();
        bfs.addLast(root);

        while(!bfs.isEmpty()) {
            double sum = 0;
            int currSize = bfs.size();

            for (int i = 0; i < currSize; i += 1) {
                TreeNode curr = bfs.removeFirst();
                sum += curr.val;
                if (curr.left != null) {
                    bfs.addLast(curr.left);
                }
                if (curr.right != null) {
                    bfs.addLast(curr.right);
                }
            }

            output.add(sum / currSize);
        }

        return output;
    }
}
