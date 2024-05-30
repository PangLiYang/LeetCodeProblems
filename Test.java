import java.util.*;

public class Test {

    public int search(int[] nums, int target) {
        return subV(nums, target, 0, nums.length - 1);
    }

    private int subV (int[] nums, int target, int start, int end) {

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (start > end) {
            return -1;
        }

        if (nums[start] < nums[mid]) {
            if (nums[start] <= target && target <= nums[mid]) {
                return bs(nums, target, start, mid - 1);
            } else {
                return subV(nums, target, mid + 1, end);
            }
        } else {
            if (mid == end || nums[mid + 1] <= target && target <= nums[end]) {
                return bs(nums, target, mid + 1, end);
            } else {
                return subV(nums, target, start, mid - 1);
            }
        }

    }

    private int bs (int[] nums, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Test tt = new Test();

        int[] nums = {4,5,6,7,0,1,2};

        int tar = 3;

        int o = tt.search(nums, tar);

        System.out.println(o);

    }
}
