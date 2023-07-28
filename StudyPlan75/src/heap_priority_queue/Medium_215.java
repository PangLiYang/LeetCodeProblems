package heap_priority_queue;

import java.util.PriorityQueue;

public class Medium_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.peek();
    }
}
