import java.util.*;

public class Test {

    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i += 1) {
            dp[i][0] = i;
        }

        for (int i = 1; i < n2 + 1; i += 1) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n1 + 1; i += 1) {
            for (int j = 1; j < n2 + 1; j += 1) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    min = Math.min(dp[i - 1][j - 1], min) + 1;
                    dp[i][j] = min;
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {

        Test tt = new Test();

        String s1 = "sea";
        String s2 = "ate";

        int o = tt.minDistance(s1, s2);

        System.out.println(o);
     }
}
