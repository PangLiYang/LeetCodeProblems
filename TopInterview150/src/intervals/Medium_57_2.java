package intervals;

import java.util.ArrayList;
import java.util.List;

public class Medium_57_2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int pos = 0;
        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] iv: intervals) {

            if (iv[1] < start) {
                list.add(iv);
                pos += 1;
                continue;
            }

            if (iv[0] > end) {
                list.add(iv);
                continue;
            }

            start = Math.min(start, iv[0]);
            end = Math.max(end, iv[1]);
        }

        list.add(pos, new int[]{start, end});

        int[][] out = new int[list.size()][2];
        list.toArray(out);

        return out;
    }
}
