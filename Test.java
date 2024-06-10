import java.util.*;

public class Test {

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

    public static void main(String[] args) {

        Test tt = new Test();

        int[] coins = {186,419,83,408};

        int amount = 6249;

        int o = tt.coinChange(coins, amount);

        System.out.println(o);
     }
}
