package linked_list;

public class Medium_61 {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }
    }

    int len = 0;

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = rev(head, 500, null);
        ListNode out = curr;
        k = k % len;
        int i = k;

        while (k > 0) {
            curr = curr.next;
            k -= 1;
        }

        ListNode second = rev(curr, 500, null);

        ListNode first = rev(out, i, second);

        return first;
    }

    private ListNode rev(ListNode head, int k, ListNode tail) {
        ListNode past = tail;

        while (head != null && k > 0) {
            ListNode sec = head.next;
            head.next = past;
            past = head;
            head = sec;

            k -= 1;
            len += 1;
        }

        return past;
    }
}
