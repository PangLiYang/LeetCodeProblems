package one_dimensional_dp;

import java.util.Arrays;

public class Medium_322 {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.sort(coins);
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int c : coins) {
            for (int i = c; i <= amount; i += 1) {
                if (dp[i - c] != -1) {
                    dp[i] = Math.min(1 + dp[i - c], dp[i]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
