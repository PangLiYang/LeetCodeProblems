package heap_priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_2542 {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i += 1) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long topKSum = 0;

        for (int i = 0; i < k; i += 1) {
            topKSum += pairs[i][0];
            pq.add(pairs[i][0]);
        }

        long answer = topKSum * pairs[k-1][1];

        for (int i = k; i < n; i += 1) {
            topKSum += pairs[i][0] - pq.poll();
            pq.add(pairs[i][0]);

            answer = Math.max(answer, topKSum * pairs[i][1]);
        }

        return answer;
    }
}
