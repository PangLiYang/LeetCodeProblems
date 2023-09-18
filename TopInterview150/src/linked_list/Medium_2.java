package linked_list;

public class Medium_2 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode();
        ListNode cur = out;
        int remainder = 0;

        while (l1 != null || l2 != null || remainder != 0) {
            int val = 0;

            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            val += remainder;
            remainder = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;

        }

        return out.next;
    }
}
