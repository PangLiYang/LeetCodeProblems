package array_string;

public class Medium_55 {
    public boolean canJump(int[] nums) {
        int gain = nums[0];

        for (int i = 1; i < nums.length; i += 1) {
            if (gain <= 0) {
                return false;
            }
            gain -= 1;
            gain = Math.max(gain, nums[i]);
        }
        return true;
    }
}
