package sliding_window;

public class Easy_643 {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < k; i += 1) {
            sum += nums[i];
            max = sum;
        }

        for (int i = 0; i < nums.length - k; i += 1) {
            sum -= nums[i];
            sum += nums[i + k];
            max = Math.max(max, sum);
        }

        return (double)max / k;
    }
}
