package multi_dimensional_dp;

public class Medium_97 {

    public boolean isInterleave(String s1, String s2, String s3) {

        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 + n2 != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        dp[0][0] = true;

        for (int i = 1; i < n1 + 1; i += 1) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < n2 + 1; i += 1) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < dp.length; i += 1) {
            for (int j = 1; j < dp[0].length; j += 1) {

                boolean cond1 = dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                boolean cond2 = dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);

                dp[i][j] = cond1 || cond2;
            }
        }

        return dp[n1][n2];
    }
}
