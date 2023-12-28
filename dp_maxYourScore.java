import java.util.Arrays;

public class dp_maxYourScore {

    private static int maxYouScore(int[] arr) {

        int n = arr.length;

        int max = 0;

        for (int i = 0; i < n; i += 1) {
            int curr = 0;
            for (int j = i; j < n; j += 1) {
                curr += arr[j];
                if (arr[j] > 0) {
                    max = Math.max(max, curr);
                }
            }
        }

        return max;
    }

    private static int[] bestOfScore(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[0] = arr[0];

        for (int i = 1; i < n; i += 1) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        return dp;
    }

    private static int[] noAdjacentScore(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]);

        int out = recAdjacentScore(arr, dp, n - 1);

        return dp;
    }

    private static int recAdjacentScore(int[] arr, int[] dp, int n) {

        if (dp[n] != Integer.MIN_VALUE) {
            return dp[n];
        }

        int best = Math.max(recAdjacentScore(arr, dp, n - 1),
                            arr[n] + recAdjacentScore(arr, dp, n - 2));

        dp[n] = Math.max(best, arr[n]);
//        dp[n] = best;

        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = {-50, -300, -20, 10, 80 ,-20, 100, -500, 20};

//        int[] dp = noAdjacentScore(arr);
        int[] dp = bestOfScore(arr);

        for (int i : dp) {
            System.out.print(i + ", ");
        }

    }
}
