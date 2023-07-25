package bt_bfs;

import java.util.LinkedList;

public class Medium_1161 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        int max = root.val;
        int sum;
        int size;
        int layer = 1;
        int result = layer;

        list.add(root);

        while (!list.isEmpty()) {
            size = list.size();
            sum = 0;
            while (size > 0) {
                int value = list.getFirst().val;
                addChild(list.removeFirst(), list);
                sum += value;
                size -= 1;
            }

            if (sum > max) {
                result = layer;
                max = sum;
            }

            layer += 1;
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
