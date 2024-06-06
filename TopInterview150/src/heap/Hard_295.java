package heap;

import java.util.PriorityQueue;

public class Hard_295 {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public Hard_295() {
        pq1 = new PriorityQueue<>();
        pq2 = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {

        int n1 = pq1.size();
        int n2 = pq2.size();

        if (pq1.isEmpty()) {
            pq1.offer(num);

            return;
        }

        if (pq2.isEmpty()) {
            if (pq1.peek() >= num) {
                pq2.offer(num);
            } else {
                pq2.offer(pq1.poll());
                pq1.offer(num);
            }

            return;
        }

        if (n1 <=n2) {
            if (pq2.peek() <= num) {
                pq1.offer(num);
            } else {
                pq1.offer(pq2.poll());
                pq2.offer(num);
            }
        } else {
            if (pq1.peek() >= num) {
                pq2.offer(num);
            } else {
                pq2.offer(pq1.poll());
                pq1.offer(num);
            }
        }

    }

    public double findMedian() {
        int n = pq1.size() + pq2.size();

        if (n % 2 == 0) {
            return (pq1.peek() + pq2.peek()) / 2.0;
        }

        return pq1.peek() * 1.0;
    }
}
