package binary_tree_bfs;

import java.util.LinkedList;
import java.util.List;

public class Medium_199 {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        LinkedList<TreeNode> bfs = new LinkedList<>();

        if (root == null) {
            return output;
        }

        bfs.addLast(root);

        while(bfs.size() != 0) {
            output.add(bfs.getLast().val);
            int currSize = bfs.size();

            for (int i = 0; i < currSize; i += 1) {
                TreeNode curr = bfs.removeFirst();
                if (curr.left != null) {
                    bfs.addLast(curr.left);
                }
                if (curr.right != null) {
                    bfs.addLast(curr.right);
                }
            }
        }

        return output;
    }
}
