import java.util.*;

public class Test {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        Queue<Integer> qu = new LinkedList<>();

        ListNode future = head.next;
        ListNode next = head;
        ListNode curr = head;
        ListNode start = head;

        while (future != null) {
            qu.add(curr.val);
            next = future;
            future = next.next;
            next.next = curr;
            curr = next;
        }

        start.next = null;

        while (curr != null) {
            max = Math.max(max, curr.val + qu.remove());
            curr = curr.next;
        }
        return max;
    }

}
