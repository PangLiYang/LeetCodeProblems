import java.util.Arrays;
import java.util.Stack;

public class dp_longestSubsequence2 {

    private static void binarySearchUpdate(int[] dp, int[] arr, int i, int st, int end, int[] dp2) {
        int m = st + (end - st) / 2;

        if (m == 0) {
            dp[m] = i;
            dp2[i] = 0;
            return;
        }

        if (arr[dp[m]] >= arr[i] && arr[dp[m - 1]] < arr[i]) {
            dp[m] = i;
            dp2[i] = dp[m - 1] + 1;
        } else if (arr[dp[m]] < arr[i]) {
            binarySearchUpdate(dp, arr, i, m + 1, end, dp2);
        } else {
            binarySearchUpdate(dp, arr, i, st, m - 1, dp2);
        }
    }

    private static int[] findLISL(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(dp2, Integer.MAX_VALUE);


        int idx = 0;
        dp[0] = 0;
        dp2[0] = 0;

        for (int i = 1; i < n; i += 1) {
            if (arr[i] > arr[dp[idx] ]) {
                idx += 1;
                dp[idx] = i;
                dp2[i] = dp[idx - 1] + 1;
            } else {
                binarySearchUpdate(dp, arr, i, 0, idx, dp2);
            }
        }

        return dp2;
    }

    private static void printDp(int[] dp) {
        for (int i : dp) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    private static void outputRes(int[] arr, int[] dpL, int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[v]);

        int idx = dpL[v] - 1;

        while (idx > 0) {
            stack.push(arr[idx]);
            idx = dpL[idx] - 1;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 11, 12, 1, 8 ,2, 7, 3, 4, 4};

        int[] dpL = findLISL(arr);

        printDp(dpL);

        outputRes(arr, dpL, 8);

    }
}
