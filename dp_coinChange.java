public class dp_coinChange {

    private static int[][] checkChange(int[] c, int n, int v) {
        int[][] dp = new int[n][v + 1];

        for (int j = 0; j < v + 1; j += 1) {
            dp[0][j] = 0;
        }

        for (int j = 1; j < v + 1; j += 1) {
            if ((j % c[0]) == 0) {
                dp[0][j] = j / c[0];
            } else {
                dp[0][j] = Integer.MAX_VALUE;
            }

        }

        for (int j = 1; j < v + 1; j += 1) {
            for (int i = 1; i < n; i += 1) {
                if (c[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - c[i]], dp[i - 1][j]);
                }
            }
        }

        return dp;
    }

    private static int[][] checkChange2(int[] c, int n, int v) {
        int idx = 0;
        int[][] dp = new int[n][c[n - 1] + 1];

        for (int j = 0; j < c[n - 1] + 1; j += 1) {
            dp[0][j] = 0;
        }

        for (int j = 1; j < c[n - 1] + 1; j += 1) {
            if ((j % c[0]) == 0) {
                dp[0][j] = j / c[0];
            } else {
                dp[0][j] = Integer.MAX_VALUE;
            }

        }

        for (int j = 1; j < v + 1; j += 1) {

            if (j > c[n - 1]) {
                idx = j % c[n - 1];
                if ((j % c[0]) == 0) {
                    dp[0][idx] = j / c[0];
                } else {
                    dp[0][idx] = Integer.MAX_VALUE;
                }
            } else {
                idx = j;
            }

            for (int i = 1; i < n; i += 1) {
                if (c[i] > j) {
                    dp[i][idx] = dp[i - 1][idx];
                } else {
                    dp[i][idx] = Math.min(1 + dp[i][(j - c[i]) % c[n - 1]], dp[i - 1][idx]);
                }
            }
        }

        return dp;
    }


    public static void main(String[] args) {
        int[] c =  {1, 5, 6, 9};
        int v = 15;
        int[][] dp = checkChange(c, c.length, v);

        for (int[] j : dp) {
            for (int i : j) {
                System.out.print(i + ",");
            }
            System.out.println();
        }

        int[][] ans = checkChange2(c, c.length, v);

        for (int[] j : ans) {
            for (int i : j) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
