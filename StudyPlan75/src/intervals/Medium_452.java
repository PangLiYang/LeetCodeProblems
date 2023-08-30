package intervals;

import java.util.Arrays;

public class Medium_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;

        if (points[0][0] == k) {
            ans += 1;
        }

        for (int i = 0; i < points.length; i += 1) {
            if (points[i][0] > k) {
                k = points[i][1];
                ans += 1;
            }
        }
        return ans;
    }
}
