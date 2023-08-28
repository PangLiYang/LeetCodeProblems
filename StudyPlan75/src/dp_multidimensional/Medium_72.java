package dp_multidimensional;

public class Medium_72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i += 1) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i += 1) {
            dp[0][i] = i;
        }

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int repl = dp[i][j];
                    int del = dp[i + 1][j];
                    int insr = dp[i][j + 1];
                    if (repl < del) {
                        dp[i + 1][j + 1] = 1 + Math.min(repl, insr);
                    } else {
                        dp[i + 1][j + 1] = 1 + Math.min(del, insr);
                    }
                }
            }
        }

        return dp[n][m];
    }
}
