package bt_dfs;

import java.util.ArrayList;
import java.util.List;

public class Easy_872 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();

        dfs(root1, seq1);
        dfs(root2, seq2);

        return seq1.equals(seq2);

    }

    private void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
            return;
        }

        if (node.left == null) {
            dfs(node.right, seq);
            return;
        }

        if (node.right == null) {
            dfs(node.left, seq);
            return;
        }

        dfs(node.right, seq);
        dfs(node.left, seq);
    }
}
