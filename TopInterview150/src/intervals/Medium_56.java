package intervals;

import java.util.Arrays;

public class Medium_56 {
    public int[][] merge(int[][] intervals) {

        int k = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i += 1) {
            int[] cur = new int[2];
            cur[0] = intervals[i][0];
            int next = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= next) {
                next = Math.max(next, intervals[i + 1][1]);
                i += 1;
            }
            cur[1] = next;
            intervals[k] = cur;
            k += 1;
        }

        return Arrays.copyOfRange(intervals, 0, k);
    }
}
