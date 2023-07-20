package prefix_sum;

public class Easy_724 {
    public int pivotIndex(int[] nums) {
        int pivot;
        int lsum = 0;
        int rsum = 0;

        for (int i = 1; i < nums.length; i += 1) {
            rsum += nums[i];
        }

        if (rsum == lsum) {
            return 0;
        }

        for (pivot = 1; pivot < nums.length; pivot += 1) {
            lsum += nums[pivot -1];
            rsum -= nums[pivot];

            if (lsum == rsum) {
                return pivot;
            }
        }

        return -1;
    }
}
