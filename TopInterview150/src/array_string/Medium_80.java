package array_string;

public class Medium_80 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int val = nums[0];
        int count = 0;

        for (int i = 1, pos = 1; i < nums.length; i += 1) {
            if (nums[i] != val) {
                if (i != pos) {
                    nums[pos] = nums[i];
                }
                k += 1;
                pos += 1;
                val = nums[i];
                count = 0;
            } else if (count == 0) {
                if (i != pos) {
                    nums[pos] = nums[i];
                }
                k += 1;
                pos += 1;
                count = 1;
            }
        }

        return k;
    }
}
