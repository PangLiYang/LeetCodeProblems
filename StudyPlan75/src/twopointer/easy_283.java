package twopointer;

public class easy_283 {
    public void moveZeroes(int[] nums) {
        int swapIndex = 0;

        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] != 0) {
                if (swapIndex != i) {
                    nums[swapIndex] = nums[i];
                }
                swapIndex += 1;
            }
        }

        for (int i = swapIndex; i < nums.length; i += 1) {
            nums[i] = 0;
        }
    }
}
