import java.util.*;

public class Test {

    public int maxPoints(int[][] points) {

        int ret = 0;

        for (int[] p1 : points) {
            Map<Double, Integer> cmap = new HashMap<>();

            for (int[] p2 : points) {
                if (Arrays.equals(p1, p2)) {
                    continue;
                }

                double slope = 1.0 * (p2[1] - p1[1]) / (p2[0] - p1[0]);

                cmap.put(slope, cmap.getOrDefault(slope, 0) + 1);
            }

            for (double slope : cmap.keySet()) {
                if (cmap.get(slope) > ret) {
                    ret = cmap.get(slope);
                }
            }
        }

        return ret + 1;
    }

    public static void main(String[] args) {

        Test tt = new Test();

        int[][] ps = {{0,0},{94911151,94911150},{94911152,94911151}};

        int o = tt.maxPoints(ps);

        System.out.println(o);
     }
}
