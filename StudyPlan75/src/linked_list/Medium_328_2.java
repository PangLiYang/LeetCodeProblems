package linked_list;

public class Medium_328_2 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddCurr = head;
        ListNode evenStart = head.next;
        ListNode evenCurr = head.next;

        while (evenCurr.next != null && evenCurr.next.next != null) {
            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;
            evenCurr.next = oddCurr.next;
            evenCurr = evenCurr.next;
        }

        if (evenCurr.next != null) {
            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;
        }

        evenCurr.next = null;
        oddCurr.next = evenStart;

        return head;
    }
}
