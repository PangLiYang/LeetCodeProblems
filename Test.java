import java.util.*;

public class Test {

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        if (nums[1] < nums[0]) {
            return 0;
        }

        if (nums[n - 2] < nums[n - 1]) {
            return n-1;
        }

        int start = 1;
        int end = n - 2;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            int curr = nums[mid];

            if (curr > nums[mid - 1] && curr > nums[mid + 1]) {
                return mid;
            } else if (curr < nums[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Test tt = new Test();

        int[] nums = {1,2,1,3,5,6,4};

        int o = tt.findPeakElement(nums);

        System.out.println(o);

    }
}
