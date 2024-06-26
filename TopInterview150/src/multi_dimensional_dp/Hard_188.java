package multi_dimensional_dp;

public class Hard_188 {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int p = 2 * k + 1;
        int[][] dp = new int[p][n];

        dp[1][0] = -prices[0];

        for (int i = 2; i < p; i += 1) {
            dp[i][0] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n ; i += 1) {

            for (int j = 1; j < p; j += 1) {
                if (j % 2 == 1) {
                    dp[j][i] = Math.max(dp[j - 1][i - 1] - prices[i], dp[j][i - 1]);
                } else {
                    dp[j][i] = Math.max(dp[j - 1][i - 1] + prices[i], dp[j][i - 1]);
                }
            }
        }

        int best = 0;

        for (int i = 2; i < p; i+= 1) {
            best = Math.max(best, dp[i][n - 1]);
        }

        return best;
    }
}
