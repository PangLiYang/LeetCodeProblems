package array_string;

public class Easy_169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int val = 0;

        for (int i = 0; i < nums.length; i += 1) {
            if (count == 0) {
                count += 1;
                val = nums[i];
            } else if (nums[i] == val) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        return val;
    }
}
