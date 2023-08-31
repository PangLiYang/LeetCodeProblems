package array_string;

public class Easy_27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int pos = 0;

        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] != val) {
                if (pos != i) {
                    nums[pos] = nums[i];
                }
                pos += 1;
            } else {
                count += 1;
            }
        }

        return nums.length - count;
    }
}
