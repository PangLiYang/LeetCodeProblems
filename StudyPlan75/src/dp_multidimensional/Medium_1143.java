package dp_multidimensional;

public class Medium_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Medium_1143 tt = new Medium_1143();
        System.out.println(tt.longestCommonSubsequence("horse", "ros"));
        System.out.println("intention".length());
        System.out.println("execution".length());
    }
}
