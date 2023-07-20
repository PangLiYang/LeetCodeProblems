package sliding_window;

public class Medium_1004 {
    public int longestOnes(int[] nums, int k) {
        int hasFlip = 0;
        int i = 0;
        int j;

        for (j = 0; j < nums.length; j += 1) {
            if (nums[j] == 0) {
                hasFlip += 1;
            }

            if (k < hasFlip) {
                if (nums[i] == 0) {
                    hasFlip -= 1;
                }
                i += 1;
            }
        }

        return j - i;
    }
}
