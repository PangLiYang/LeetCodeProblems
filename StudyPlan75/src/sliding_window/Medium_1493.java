package sliding_window;

public class Medium_1493 {
    public int longestSubarray(int[] nums) {
        int deleteChance = 1;
        int i = 0;
        int j;

        for (j = 0; j < nums.length; j += 1) {
            if (nums[j] == 0) {
                deleteChance -= 1;
            }
            if (deleteChance < 0) {
                if (nums[i] == 0) {
                    deleteChance += 1;
                }
                i += 1;
            }
        }

        return j - i - 1;
    }
}
