package dp_1d;

public class Medium_790 {
    long[] dp;

    public int numTilings(int n) {

        dp = new long[n + 3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;

        return (int) findTiles(n - 1);
    }

    private long findTiles(int n) {

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = (2 * findTiles(n - 1) + findTiles(n - 3)) % 1000000007;

        return dp[n];
    }
}
