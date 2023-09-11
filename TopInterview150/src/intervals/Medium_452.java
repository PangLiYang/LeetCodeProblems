package intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Medium_452 {
    public int findMinArrowShots(int[][] points) {
        int out = 0;
        int tail = Integer.MIN_VALUE;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        for (int[] iv: points) {
            if (iv[0] > tail || tail == Integer.MIN_VALUE) {
                out += 1;
                tail = iv[1];
            }
        }

        return out;
    }
}
