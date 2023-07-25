package bt_bfs;

import java.util.LinkedList;
import java.util.List;

public class Medium_199 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        list.add(root);

        while (!list.isEmpty()) {
            result.add(list.getLast().val);
            int size = list.size();
            for (int i = 0; i < size; i += 1) {
                addChild(list.removeFirst(), list);
            }
        }

        return result;
    }

    private void addChild(TreeNode node, LinkedList<TreeNode> list) {
        if (node.left != null) {
            list.addLast(node.left);
        }

        if (node.right != null) {
            list.addLast(node.right);
        }
    }
}
