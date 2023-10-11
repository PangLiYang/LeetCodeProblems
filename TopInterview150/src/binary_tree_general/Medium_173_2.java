package binary_tree_general;

import java.util.LinkedList;

public class Medium_173 {

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

    LinkedList<TreeNode> nodeList;

    public Medium_173(TreeNode root) {
        nodeList = new LinkedList<>();
        createList(root, nodeList);
    }

    public int next() {
        return nodeList.removeFirst().val;
    }

    public boolean hasNext() {
        return !nodeList.isEmpty();
    }

    private void createList(TreeNode root, LinkedList<TreeNode> nodeList) {
        dfs(root, nodeList);
    }

    private void dfs(TreeNode root, LinkedList<TreeNode> nodeList) {
        if (root == null) {
            return;
        }

        dfs(root.left, nodeList);
        nodeList.addLast(root);
        dfs(root.right, nodeList);
    }
}
