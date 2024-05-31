package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Hard_502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        int[][] proj = new int[n][2];

        for (int i = 0; i < n; i += 1) {
            proj[i][0] = capital[i];
            proj[i][1] = profits[i];
        }

        Arrays.sort(proj, (a, b) -> Integer.compare(a[0], b[0]));
        int idx = 0;

        while (k > 0) {

            for (int i = idx; i < n; i += 1) {
                if (w >= proj[i][0]) {
                    pq.add(-proj[i][1]);
                    idx += 1;
                } else {
                    break;
                }
            }

            if (pq.isEmpty()) {
                return w;
            }

            int curr = -pq.poll();

            w += curr;
            k -= 1;
        }

        return w;
    }
}
