package multi_dimensional_dp;

import java.util.Arrays;
import java.util.List;

public class Medium_120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);
        dp[0][0] = triangle.get(0).get(0);

        int cIdx = 1;

        for (int i = 1; i < n; i += 1) {
            int next = -cIdx + 1;
            int[] src = dp[next];
            int[] target = dp[cIdx];
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j += 1) {
                if (j == 0) {
                    target[j] = src[0] + curr.get(j);
                } else {
                    target[j] = Math.min(src[j - 1], src[j]) + curr.get(j);
                }
            }
            cIdx = next;
        }

        int min = Integer.MAX_VALUE;
        cIdx = -cIdx + 1;
        for (int i : dp[cIdx]) {
            min = Math.min(min, i);
        }

        return min;
    }
}
