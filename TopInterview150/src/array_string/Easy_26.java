package array_string;

public class Easy_26 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int value = nums[0];

        for (int i = 1, pos = 1; i < nums.length; i += 1) {
            if (nums[i] != value) {
                if (i != pos) {
                    nums[pos] = nums[i];
                }
                value = nums[i];
                pos += 1;
                k += 1;
            }
        }

        return k;
    }
}
