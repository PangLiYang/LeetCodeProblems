package sliding_window;

public class Medium_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int lp = 0;
        int sum = nums[lp];
        int min = Integer.MAX_VALUE;

        if (sum >= target) {
            return 1;
        }

        int rp = 1;

        while (rp < nums.length) {
            sum += nums[rp];

            while (sum >= target) {
                min = Math.min(min, rp - lp + 1);
                sum -= nums[lp];
                lp += 1;
            }

            rp += 1;
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }

        return min;

    }

    public static void main(String[] args) {
        int[] input = {1,4,4};
        Medium_209 tt = new Medium_209();
        System.out.println(tt.minSubArrayLen(4, input));
    }
}
