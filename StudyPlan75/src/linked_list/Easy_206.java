package linked_list;

public class Easy_206 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = null;

        while (head != null) {
            curr = new ListNode(head.val, curr);
            head = head.next;
        }

        return curr;
    }

}
