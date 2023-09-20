package linked_list;

public class Medium_82 {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = new ListNode(-101);
        ListNode out = curr;

        int temp = -102;

        while (head != null) {

            if (head.next != null && head.val == head.next.val) {
                temp = head.val;
            } else if (head.val != temp) {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }

            head = head.next;
        }

        return out.next;
    }
}
