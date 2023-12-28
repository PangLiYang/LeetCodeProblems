import java.util.Arrays;

public class dp_longestSubsequence {

    static class MyWrap {
        public int val;

        public MyWrap(int val) {
            this.val = val;
        }
    }

    private static int[][] lisA(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n];


        for (int i = 0; i < n + 1; i += 1) {
            for (int j = 0; j < n; j += 1) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n + 1; i += 1) {
            min = Math.min(min, arr[i - 1]);
            dp[i][0] = min;
        }

        for (int i = 1; i < n + 1; i += 1) {
            for (int j = 1; j < n; j += 1) {
                if (arr[i - 1] > dp[i][j - 1]) {
                    dp[i][j] = Math.min(arr[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                if (dp[i][j] == Integer.MAX_VALUE) {
                    break;
                }
            }
        }

        return dp;
    }

    private static int[] updateRow2(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int idx = 0;
        dp[0] = arr[0];

//        printDp(dp);

        for (int i = 1; i < n; i += 1) {
            if (arr[i] > dp[idx]) {
                idx += 1;
                dp[idx] = arr[i];
            } else {
                binarySearchUpdate(dp, arr[i], 0, idx);
            }
//            printDp(dp);
        }

        return dp;
    }

    private static void updateRow1(int[] arr, int[] dp, int i, MyWrap v) {

        if (arr[i] > dp[v.val]) {
            v.val += 1;
            dp[v.val] = arr[i];
        } else {
            binarySearchUpdate(dp, arr[i], 0, v.val);
        }
    }

    private static void binarySearchUpdate(int[] dp, int obj, int st, int end) {
        int m = st + (end - st) / 2;

        if (m == 0) {
            dp[m] = obj;
            return;
        }

        if (dp[m] >= obj && dp[m - 1] < obj) {
            dp[m] = obj;
        } else if (dp[m] < obj) {
            binarySearchUpdate(dp, obj, m + 1, end);
        } else {
            binarySearchUpdate(dp, obj, st, m - 1);
        }
    }

    private static int[] findLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        MyWrap idx = new MyWrap(0);
        dp[0] = arr[0];

        for (int i = 1; i < n; i += 1) {
            updateRow1(arr, dp, i, idx);
            printDp(dp);
        }

        return dp;
    }

    private static void printDp(int[] dp) {
        for (int i : dp) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 11, 12, 1, 8 ,2, 7, 3, 4, 4};

        int[][] dp = lisA(arr);

        for (int[] r : dp) {
            for(int i : r) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

        System.out.println("-----");

        int[] dp2 = findLIS(arr);

    }
}
