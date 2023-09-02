package array_string;

import java.util.Arrays;

public class Medium_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 1;

        for (int i = 0; i < n; i += 1) {
            int steps = nums[i] + i;
            int curr = ans[i];
            for (int j = pos; j <= steps; j += 1) {
                ans[j] = curr + 1;
                pos += 1;

                if (j == n - 1) {
                    return ans[j];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] input = {2,1,1,1,1};
        Medium_45 tt = new Medium_45();
        System.out.println(tt.jump(input));
    }
}
