package heap_priority_queue;

import java.util.PriorityQueue;

public class Medium_2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int leftIndex = 0;
        int rightIndex = n - 1;
        long answer = 0;
        PriorityQueue<Integer> pq;

        if (n <= 2 * candidates) {
            pq = new PriorityQueue<>(n);
            for (int cost: costs) {
                pq.add(cost);
            }
            for (int i = 0; i < k; i += 1) {
                answer += pq.poll();
            }
            return answer;
        } else if (k == n) {
            for (int cost: costs) {
                answer += cost;
            }
            return answer;
        }

        pq = new PriorityQueue<>(candidates);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(candidates);

        for (int i = 0; i < candidates; i += 1) {
            pq.add(costs[leftIndex]);
            leftIndex += 1;
            pq2.add(costs[rightIndex]);
            rightIndex -= 1;
        }

        for (int i = 0; i < k; i += 1) {
            if (pq.isEmpty()) {
                answer += pq2.poll();
                if (leftIndex <= rightIndex) {
                    pq2.add(costs[rightIndex]);
                    rightIndex -= 1;
                }
                continue;
            }

            if (pq2.isEmpty()) {
                answer += pq.poll();
                if (leftIndex <= rightIndex) {
                    pq.add(costs[leftIndex]);
                    leftIndex += 1;
                }
                continue;
            }

            if (pq.peek() <= pq2.peek()) {
                answer += pq.poll();
                if (leftIndex <= rightIndex) {
                    pq.add(costs[leftIndex]);
                    leftIndex += 1;
                }
            } else {
                answer += pq2.poll();
                if (leftIndex <= rightIndex) {
                    pq2.add(costs[rightIndex]);
                    rightIndex -= 1;
                }
            }
        }

        return answer;
    }
}
