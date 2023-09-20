package linked_list;

public class Medium_19 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = new ListNode();
        ListNode out = curr;
        curr.next = head;

        ListNode fast = head;

        for (int i = 0; i < n; i += 1) {
            fast = fast.next;
        }

        while (fast != null) {
            curr = curr.next;
            fast = fast.next;
        }

        curr.next = curr.next.next;

        return out.next;

    }
}
