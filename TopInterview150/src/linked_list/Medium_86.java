package linked_list;

public class Medium_86 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur1 = new ListNode();
        ListNode cur2 = new ListNode();
        ListNode out1 = cur1;
        ListNode out2 = cur2;

        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }

        cur2.next = null;
        cur1.next = out2.next;

        return out1.next;
    }
}
