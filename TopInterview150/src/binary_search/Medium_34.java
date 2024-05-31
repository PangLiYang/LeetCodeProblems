package binary_search;

public class Medium_34 {

    public int[] searchRange(int[] nums, int target) {

        int[] out = new int[2];

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int first = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    first = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        out[0] = first;

        if (first == -1) {
            out[1] = -1;
            return out;
        }

        start = first;
        end = n - 1;
        int second = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                if (mid == n - 1 || nums[mid + 1] != target) {
                    second = mid;
                    break;
                } else {
                    start = start + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        out[1] = second;


        return out;
    }
}
