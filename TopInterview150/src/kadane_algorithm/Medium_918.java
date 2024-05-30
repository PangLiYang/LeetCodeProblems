package kadane_algorithm;

public class Medium_918 {

    public int maxSubarraySumCircular(int[] nums) {

        int sum = 0, localMax = 0, localMin = 0;
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;

        for (int i : nums) {
            sum += i;
            localMax = Math.max(i, i + localMax);
            localMin = Math.min(i, i + localMin);

            if (localMax > globalMax) {
                globalMax = localMax;
            }

            if (localMin < globalMin) {
                globalMin = localMin;
            }
        }

        return globalMax >= 0 ? Math.max(globalMax, sum - globalMin) : globalMax;
    }

}
