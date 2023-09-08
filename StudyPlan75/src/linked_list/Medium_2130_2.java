package linked_list;

public class Medium_2130_2 {
    ListNode head = new ListNode(1, new ListNode(100, null));

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast!= null && fast.next!= null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        head = prev;

        while (slow != null) {
            max = Math.max(max, slow.val + head.val);
            slow = slow.next;
            head = head.next;
        }

        return max;
    }
}
