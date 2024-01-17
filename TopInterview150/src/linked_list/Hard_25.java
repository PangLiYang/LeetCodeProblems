package linked_list;

public class Hard_25 {

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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        while (curr != null && count != k) {
            curr = curr.next;
            count += 1;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count - 1 > 0) {
                count -= 1;
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }

            head = curr;
        }

        return head;
    }
}
