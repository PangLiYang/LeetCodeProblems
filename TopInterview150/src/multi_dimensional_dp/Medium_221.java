package multi_dimensional_dp;

public class Medium_221 {

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int max = 0;

        for (int i = 0; i < n; i += 1) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i += 1) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < m; i += 1) {
            for (int j = 1; j < n; j += 1) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else if (dp[i - 1][j - 1] == 0) {
                    dp[i][j] = 1;
                } else if (dp[i - 1][j] == 0 || dp[i][j - 1] == 0) {
                    dp[i][j] = 1;
                } else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }

                max = Math.max(max, dp[i][j] * dp[i][j]);
            }
        }

        return max;
    }
}
