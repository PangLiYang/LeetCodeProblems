package linked_list;

public class Medium_2095_2 {

    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;

    }
}
