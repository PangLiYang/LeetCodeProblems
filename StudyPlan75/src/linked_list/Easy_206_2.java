package linked_list;

public class Easy_206_2 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        return reverseHelper(head, null);
    }

    private ListNode reverseHelper (ListNode head, ListNode rev) {
        if (head == null) {
            return rev;
        }
        ListNode next = head.next;
        head.next = rev;
        return reverseHelper(next, head);
    }
}
