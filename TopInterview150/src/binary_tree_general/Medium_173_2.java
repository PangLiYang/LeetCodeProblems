package binary_tree_general;

import java.util.Stack;

public class Medium_173_2 {

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

    Stack<TreeNode> nodeStack;

    public Medium_173_2(TreeNode root) {
        nodeStack = new Stack<>();
        addLeft(root);
    }

    public int next() {
        TreeNode curr = nodeStack.pop();
        addLeft(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    private void addLeft(TreeNode node) {

        while (node != null) {
            nodeStack.push(node);
            node = node.left;
        }
    }
}
