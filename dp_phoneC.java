import java.util.Arrays;

public class dp_phoneC {

    private static int[][] phoneC(int n, int[] f) {
        int[][] fdp = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i += 1) {
            for (int k = i; k < n; k += 1) {
                fdp[0][k] += f[i];
            }
        }

        for (int i = 1; i < n; i += 1) {
            for (int j = i; j < n; j += 1) {
                fdp[i][j] = fdp[i - 1][j] - f[i - 1];
            }
        }

        for (int j = 0; j < n; j += 1) {
            for (int k = j; k < n; k += 1) {
                dp[0][k] += (j + 1) * f[j];
            }
        }

        for (int j = 1; j < n; j += 1) {
            for (int i = 1; i < n; i += 1) {
                dp[i][j] = dp[i - 1][j] - fdp[i - 1][j];
            }
        }

        return dp;
    }

    private static int[][] phoneTD(int n, int k, int[][] c) {

        int [][] dp = new int[n][k];

        for (int i = 0; i < n; i += 1) {
            dp[i][0] = c[0][i];
        }

        int out = rdp(n, k, c, dp);

        return dp;
    }

    private static int rdp(int n, int k, int[][] c, int[][] dp) {

        if (n <= 0) {
            return 0;
        }

        if (dp[n - 1][k - 1] > 0) {
            return dp[n - 1][k - 1];
        }

        int q = Integer.MAX_VALUE;

        for (int i = 0; i < n; i += 1) {
            q = Math.min(q, c[n - i - 1][n - 1] + rdp(n - i - 1, k - 1, c, dp));
        }

        dp[n - 1][k - 1] = q;

        return dp[n - 1][k - 1];
    }

    private static int[][] phoneBU(int n, int k, int[][] c) {

        int [][] dp = new int[n][k];

        for (int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < n; i += 1) {
            dp[i][0] = c[0][i];
        }

        for (int j = 1; j < k; j += 1) {
            for (int i = 0; i < n; i += 1) {
                for (int g = 0; g <= i; g += 1) {
                    dp[i][j] = Math.min(dp[i][j], c[n - g - 1][n - 1] + dp[n - g - 1][j - 1]);
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        int[] f =  {1, 5, 6, 9, 7, 11, 3, 5, 6, 7};
        int n = f.length;
        int k = 3;
        int[][] c = phoneC(n, f);

        int[][] dp = phoneTD(n, k, c);

        int[][] dp2 = phoneBU(n, k, c);

        for (int[] j : dp) {
            for (int i : j) {
                System.out.print(i + ",");
            }
            System.out.println();
        }

        System.out.println();

        for (int[] j : dp2) {
            for (int i : j) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
