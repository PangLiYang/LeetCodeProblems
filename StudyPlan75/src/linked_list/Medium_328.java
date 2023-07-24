package linked_list;

public class Medium_328 {

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

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenStart = head.next;
        ListNode pos = head.next;
        boolean toOdd = true;

        while (pos.next != null) {
            if (toOdd) {
                oddNode.next = pos.next;
                oddNode = oddNode.next;
                toOdd = false;
            } else {
                evenNode.next = pos.next;
                evenNode = evenNode.next;
                toOdd = true;
            }
            pos = pos.next;
        }

        evenNode.next = null;
        oddNode.next = evenStart;

        return head;
    }
}
