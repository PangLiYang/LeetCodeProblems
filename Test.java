import java.util.*;

public class Test {

    public int maxSubArray(int[] nums) {

        int localMax = nums[0];
        int globalMax = localMax;

        for (int i = 1; i < nums.length; i += 1) {
            localMax = Math.max(nums[i], nums[i] + localMax);

            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {

        Test tt = new Test();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int o = tt.maxSubArray(nums);

        System.out.println(o);

    }
}
