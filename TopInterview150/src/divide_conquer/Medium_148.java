package divide_conquer;

public class Medium_148 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        return mergeList(sortList(head), sortList(slow));

    }

    public ListNode mergeList(ListNode left, ListNode right) {

        ListNode ret = null;
        ListNode iter = null;

        if (left.val <= right.val) {
            ret = left;
            iter = ret;
            left = left.next;
        } else {
            ret = right;
            iter = ret;
            right = right.next;
        }

        while (left != null && right != null) {
            if (left.val <= right.val) {
                iter.next = left;
                iter = iter.next;
                left = left.next;
            } else {
                iter.next = right;
                iter = iter.next;
                right = right.next;
            }
        }

        if (left != null) {
            iter.next = left;
        }

        if (right != null) {
            iter.next = right;
        }

        return ret;
    }

}
