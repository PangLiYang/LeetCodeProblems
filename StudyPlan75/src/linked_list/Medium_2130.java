package linked_list;

import java.util.Stack;

public class Medium_2130 {

    private class ListNode {
        int val;
        ListNode next;
    }

    public int pairSum(ListNode head) {
        int n = 1;
        ListNode curr = head;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int temp = 0;

        while (curr.next != null) {
            n += 1;
            curr = curr.next;
        }

        for (int i = 0; i < n / 2; i += 1) {
            st.push(head.val);
            head = head.next;
        }

        for (int i = n / 2; i < n; i += 1) {
            temp = head.val + st.pop();
            max = Math.max(max, temp);
            head = head.next;
        }

        return max;
    }
}
