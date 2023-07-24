package linked_list;

public class Medium_2095 {

    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteMiddle(ListNode head) {
        int count = 1;
        ListNode cur = head;

        if (head.next == null) {
            return null;
        }

        while (cur.next != null) {
            cur = cur.next;
            count += 1;
        }

        count /= 2;

        cur = head;

        while (count > 1) {
            cur = cur.next;
            count -= 1;
        }

        if (cur.next.next == null) {
            cur.next = null;
        } else {
            cur.next = cur.next.next;
        }

        return head;
    }
}
