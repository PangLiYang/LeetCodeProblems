package binary_search;

public class Easy_35 {

    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int idx = 0;

        while (start <= end) {
            idx = start + (end - start) / 2;
            int curr = nums[idx];

            if (curr == target) {
                return idx;
            } else if (curr < target) {
                start = idx + 1;
            } else {
                end = idx - 1;
            }
        }

        return nums[idx] < target? idx + 1 : idx;
    }
}
