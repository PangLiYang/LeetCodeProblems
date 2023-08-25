package dp_1d;

public class Medium_198 {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];

        for (int i = 0; i < n; i += 1) {
            dp[i] = -1;
        }

        if (n == 1) {
            return nums[0];
        }

        return Math.max(maxCash(nums, n - 1), maxCash(nums, n - 2));

    }

    private int maxCash (int[] nums, int n) {
        if (n == 0) {
            return nums[n];
        }

        if (n == 1) {
            return nums[n];
        }

        if (n == 2) {
            return nums[0] + nums[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = nums[n] + Math.max(maxCash(nums, n - 2), maxCash(nums, n - 3));

        return dp[n];
    }
}
