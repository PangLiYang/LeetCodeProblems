package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Medium_373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ret = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = nums2.length;

        for (int i : nums1) {
            pq.offer(new int[]{i + nums2[0], 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int sum = pair[0];
            int idx = pair[1];

            List<Integer> curr = new ArrayList<>();
            curr.add(sum - nums2[idx]);
            curr.add(nums2[idx]);
            ret.add(curr);

            if (idx + 1 < n) {
                pq.offer(new int[]{sum - nums2[idx] + nums2[idx + 1], idx + 1});
            }

            k -= 1;
        }

        return ret;
    }
}
