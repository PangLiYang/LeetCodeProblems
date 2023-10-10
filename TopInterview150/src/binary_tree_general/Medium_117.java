package binary_tree_general;

public class Medium_117 {

    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {}

        Node(int val) {
            this.val = val;
        }
    }

    public Node connect(Node root) {

        Node start = new Node();
        Node pre = start;
        Node out = root;

        while (root != null) {

            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }

            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }

            root = root.next;

            if (root == null) {
                pre = start;
                root = start.next;
                start.next = null;
            }
        }

        return out;
    }
}
