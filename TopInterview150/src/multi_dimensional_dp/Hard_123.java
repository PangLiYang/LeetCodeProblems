package multi_dimensional_dp;

public class Hard_123 {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[5][n];

        dp[1][0] = -prices[0];
        for (int i = 2; i < 5; i += 1) {
            dp[i][0] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n ; i += 1) {
            dp[1][i] = Math.max(dp[0][i - 1] - prices[i], dp[1][i - 1]);
            dp[2][i] = Math.max(dp[1][i - 1] + prices[i], dp[2][i - 1]);
            dp[3][i] = Math.max(dp[2][i - 1] - prices[i], dp[3][i - 1]);
            dp[4][i] = Math.max(dp[3][i - 1] + prices[i], dp[4][i - 1]);
        }

        int best = Math.max(dp[2][n - 1], dp[4][n - 1]);

        return Math.max(0, best);
    }
}
