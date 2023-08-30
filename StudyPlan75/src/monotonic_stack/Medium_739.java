package monotonic_stack;

import java.util.Stack;

public class Medium_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> ms = new Stack<>();
        int[] ans = new int[temperatures.length];
        ms.push(0);
        int k = temperatures[0];

        for (int i = 1; i < temperatures.length; i += 1) {
            while (!ms.empty() && temperatures[i] > k) {
                int index = ms.pop();
                ans[index] = i - index;
                if (!ms.empty()) {
                    k = temperatures[ms.peek()];
                } else {
                    k = 0;
                }
            }
            ms.push(i);
            k = temperatures[i];
        }
        return ans;
    }
}
