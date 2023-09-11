package intervals;

import java.util.Arrays;

public class Medium_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] out = new int[intervals.length + 1][2];
        int k = 0;
        int size = 0;
        int pos = 0;
        int start = newInterval[0];
        int end = newInterval[1];

        for (int i = 0; i < intervals.length; i += 1) {

            if (intervals[i][1] < start) {
                out[k][0] = intervals[i][0];
                out[k][1] = intervals[i][1];
                k += 1;
                size += 1;
                pos += 1;
                continue;
            }

            if (intervals[i][0] > end) {
                k += 1;
                out[k][0] = intervals[i][0];
                out[k][1] = intervals[i][1];
                size += 1;
                continue;
            }

            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
        }

        out[pos][0] = start;
        out[pos][1] = end;
        size += 1;

        return Arrays.copyOfRange(out, 0, size);
    }
}
