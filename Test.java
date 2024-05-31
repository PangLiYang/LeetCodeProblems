import java.util.*;

public class Test {

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

    public static void main(String[] args) {

        Test tt = new Test();

        int k = 1;
        int w = 2;

        int[] profit = {1,2,3};
        int[] capital = {0,1,1};

        int o = tt.findMaximizedCapital(k, w, profit, capital);

        System.out.println(o);
    }
}
