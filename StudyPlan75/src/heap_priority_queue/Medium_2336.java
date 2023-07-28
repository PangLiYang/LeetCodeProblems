package heap_priority_queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Medium_2336 {
    PriorityQueue<Integer> pq;
    Set<Integer> shown;
    int pos;

    public Medium_2336() {
        pq = new PriorityQueue<>();
        shown = new HashSet<>();
        pos = 1;
    }

    public int popSmallest() {
        int result;

        if (!pq.isEmpty()) {
            result = pq.poll();
            shown.remove(result);
        } else {
            result = pos;
            pos += 1;
        }

        return result;
    }

    public void addBack(int num) {

        if (num >= pos || shown.contains(num)) {
            return;
        }

        shown.add(num);
        pq.add(num);
    }
}
