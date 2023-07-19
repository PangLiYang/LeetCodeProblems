package twopointer;

import java.util.Arrays;

public class medium_1679 {
    public int maxOperations(int[] nums, int k) {
        int lp = 0;
        int rp = nums.length - 1;
        int sum;
        int count = 0;

        Arrays.sort(nums);

        while (lp < rp) {
            sum = nums[lp] + nums[rp];
            if (sum == k) {
                count += 1;
                lp += 1;
                rp -= 1;
            } else if (sum < k) {
                lp += 1;
            } else {
                rp -= 1;
            }
        }

        return count;
    }
}
