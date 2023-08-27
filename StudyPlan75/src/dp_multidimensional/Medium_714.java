package dp_multidimensional;

public class Medium_714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] free = new int[n];
        int[] hold = new int[n];

        free[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < n; i += 1) {
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
            hold[i] = Math.max(free[i - 1] - prices[i], hold[i - 1]);
        }

        return free[n - 1];
    }
}
