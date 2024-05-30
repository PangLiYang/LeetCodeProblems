package divide_conquer;

public class Hard_23 {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        return split(lists, 0, lists.length - 1);
    }

    private ListNode split(ListNode[] lists, int start, int end) {

        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode left = split(lists, start, mid);
        ListNode right = split(lists, mid + 1, end);

        return merge(left, right);
    }

    private ListNode merge (ListNode left, ListNode right) {
        ListNode ret = new ListNode(), curr = ret;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                curr = curr.next;
                left = left.next;
            } else {
                curr.next = right;
                curr = curr.next;
                right = right.next;
            }
        }

        if (left != null) {
            curr.next = left;
        }

        if (right != null) {
            curr.next = right;
        }

        return ret.next;
    }
}
