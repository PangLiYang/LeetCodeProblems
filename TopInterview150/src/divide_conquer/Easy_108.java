package divide_conquer;

import java.util.Arrays;

public class Easy_108 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return null;
        }

        if (n == 1) {
            return new TreeNode(nums[0]);
        }

        int mid = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, n);

        return new TreeNode(nums[mid], sortedArrayToBST(left), sortedArrayToBST(right));
    }
}
