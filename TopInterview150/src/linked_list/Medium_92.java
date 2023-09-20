package linked_list;

public class Medium_92 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) {
            return head;
        }

        int pos = 1;
        ListNode out = head;
        ListNode revS = null;
        ListNode revE = null;
        ListNode lp = null;
        ListNode rp = null;

        while (head != null) {
            if (pos == left - 1) {
                lp = head;
            }
            if (pos == left) {
                revS = head;
            }
            if (pos == right) {
                revE = head;
            }
            if (pos == right + 1) {
                rp = head;
            }
            pos += 1;
            head = head.next;
        }

        ListNode rev = rp;

        while (revS != revE) {
            ListNode path = revS.next;
            revS.next = rev;
            rev = revS;
            revS = path;
        }

        revS.next = rev;

        if (lp != null) {
            lp.next = revS;
            return out;
        }

        return revS;
    }
}
