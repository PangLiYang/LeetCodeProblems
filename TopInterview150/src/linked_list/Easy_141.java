package linked_list;

public class Easy_141 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode cur = head;

        while (cur != null) {
            if (cur.val == Integer.MIN_VALUE) {
                return true;
            }
            cur.val = Integer.MIN_VALUE;
            cur = cur.next;
        }

        return false;
    }

}
