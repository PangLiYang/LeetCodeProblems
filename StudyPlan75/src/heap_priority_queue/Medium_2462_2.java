package heap_priority_queue;

import java.util.PriorityQueue;

public class Medium_2462_2 {
    public long totalCost(int[] costs, int k, int candidates) {
        int lp = 0;
        int rp = costs.length - 1;
        long out = 0;

        if (lp == rp) {
            return costs[0];
        }

        PriorityQueue<Integer> leftPq = new PriorityQueue<>();
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();

        for (int i = 0; i < candidates; i += 1) {
            if (lp < rp) {
                leftPq.offer(costs[lp]);
                rightPq.offer(costs[rp]);
                lp += 1;
                rp -= 1;
            } else if (lp == rp) {
                leftPq.offer(costs[lp]);
                lp += 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < k; i += 1) {
            if (!leftPq.isEmpty() && !rightPq.isEmpty()) {
                if (leftPq.peek() <= rightPq.peek()) {
                    out += leftPq.poll();
                    if (lp <= rp) {
                        leftPq.offer(costs[lp]);
                        lp += 1;
                    }
                } else {
                    out += rightPq.poll();
                    if (lp <= rp) {
                        rightPq.offer(costs[rp]);
                        rp -= 1;
                    }
                }
            } else if (leftPq.isEmpty()) {
                out += rightPq.poll();
                if (lp <= rp) {
                    rightPq.offer(costs[rp]);
                    rp -= 1;
                }
            } else {
                out += leftPq.poll();
                if (lp <= rp) {
                    leftPq.offer(costs[rp]);
                    lp += 1;
                }
            }

        }
        return out;
    }
}
