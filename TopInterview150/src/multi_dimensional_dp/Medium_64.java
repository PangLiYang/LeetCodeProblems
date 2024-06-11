package multi_dimensional_dp;

import java.util.Arrays;

public class Medium_64 {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] ir : dp) {
            Arrays.fill(ir, Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];

        return tdDriver(grid, dp, m - 1, n - 1);
    }

    private int tdDriver(int[][] grid, int[][]dp, int i, int j) {

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int curr = Integer.MAX_VALUE;

        if (i == 0) {
            curr = grid[i][j] + tdDriver(grid, dp, i, j - 1);
        } else if (j == 0) {
            curr = grid[i][j] + tdDriver(grid, dp, i - 1, j);
        } else {
            curr = grid[i][j] + Math.min(tdDriver(grid, dp, i, j - 1), tdDriver(grid, dp, i - 1, j));
        }

        dp[i][j] = curr;

        return curr;
    }
}
