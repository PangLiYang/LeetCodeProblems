import java.util.*;

public class Test {

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

    public static void main(String[] args) {

        Test tt = new Test();

        int[] n1 = {-10,-4,0,0,6};
        int[] n2 = {3,5,6,7,8,100};
        int k = 10;

        List<List<Integer>> o = tt.kSmallestPairs(n1, n2, k);

        for (List<Integer> l : o) {
            System.out.println(l);
        }
    }
}
