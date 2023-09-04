package array_string;

public class Medium_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int leftProduct = 1;
        int rightProduct = 1;

        for (int i = 0; i < n; i += 1) {
            ans[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for (int j = n - 1; j >= 0; j -= 1) {
            ans[j] *= rightProduct;
            rightProduct *= nums[j];
        }

        return ans;
    }
}
