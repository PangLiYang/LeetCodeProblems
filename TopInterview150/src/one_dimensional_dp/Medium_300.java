package one_dimensional_dp;

public class Medium_300 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int max = 1;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i += 1) {
            dp[i] = 1;
            for (int j = 0; j < i; j += 1) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
