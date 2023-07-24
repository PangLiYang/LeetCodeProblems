package linked_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        ListNode start = head;
        int max = 0;
        while (prev != null) {
            max = Math.max(max, start.val + prev.val);
            start = start.next;
            prev = prev.next;
        }

        return max;
    }
}
