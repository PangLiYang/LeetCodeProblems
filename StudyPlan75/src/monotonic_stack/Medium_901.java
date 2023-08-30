package monotonic_stack;

import java.util.Stack;

public class Medium_901 {
    Stack<int[]> ms;

    public Medium_901() {
        ms = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;

        while (!ms.empty() && price >= ms.peek()[0]) {
            ans += ms.pop()[1];
        }

        int[] item = {price, ans};
        ms.push(item);

        return ans;
    }
}
