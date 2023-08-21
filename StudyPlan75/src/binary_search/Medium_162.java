package binary_search;

public class Medium_162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int lb = 1;
        int ub = n - 2;
        int target;

        while (lb <= ub) {
            target = lb + (ub - lb) / 2;
            if (nums[target] > nums[target + 1] && nums[target] > nums[target -1]) {
                return target;
            } else if (nums[target] < nums[target + 1]) {
                lb = target + 1;
            } else {
                ub = target - 1;
            }
        }

        return -1;

    }
}
