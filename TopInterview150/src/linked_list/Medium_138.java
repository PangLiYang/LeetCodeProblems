package linked_list;

import java.util.HashMap;
import java.util.Map;

public class Medium_138 {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();
        Node pos = head;
        Node curr = new Node(0);
        Node out = curr;

        while (head != null) {

            curr.next = new Node(head.val);
            map.put(head, curr.next);

            curr = curr.next;
            head = head.next;
        }

        curr = out.next;

        while (pos != null) {
            if (pos.random != null) {
                curr.random = map.get(pos.random);
            }
            curr = curr.next;
            pos = pos.next;
        }

        return out.next;
    }
}
