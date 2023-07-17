package arrayandstring;

public class medium_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] targetArr = new int[nums.length];
        int lp = 1;
        int rp = 1;

        for (int i = 0; i < nums.length; i += 1) {
            targetArr[i] = 1;
            targetArr[i] *= lp;
            lp *= nums[i];
        }

        for (int i = nums.length - 1; i > -1; i -= 1) {
            targetArr[i] *= rp;
            rp *= nums[i];
        }

        return targetArr;
    }
}
