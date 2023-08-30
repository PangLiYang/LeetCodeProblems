package intervals;

import java.util.Arrays;

public class Medium_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int k = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i += 1) {
            if (intervals[i][0] >= k) {
                k = intervals[i][1];
                ans += 1;
            }
        }

        return intervals.length - ans;
    }
}
