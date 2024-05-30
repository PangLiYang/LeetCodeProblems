package kadane_algorithm;

public class Medium_53 {

    public int maxSubArray(int[] nums) {

        int localMax = nums[0];
        int globalMax = localMax;

        for (int i = 1; i < nums.length; i += 1) {
            localMax = Math.max(nums[i], nums[i] + localMax);

            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }
}
