import java.util.*;

public class Test {

    public int leastInterval(char[] tasks, int n) {

        int[] map = new int[26];

        for (char c : tasks) {
            map[c - 'A'] += 1;
        }

        Comparator<Integer> comparator = new NodeComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

        for (int i : map) {
            if (i > 0) {
                pq.add(i);
            }
        }

        int steps = 0;

        while (!pq.isEmpty()) {
            List<Integer> old = new LinkedList<>();
            boolean notFind = false;

            for (int i = 0; i <= n; i += 1) {

                if (!pq.isEmpty()) {
                    int curr = pq.poll();
                    curr -= 1;

                    if (curr > 0) {
                        old.add(curr);
                    }
                }

                steps += 1;

                if (pq.isEmpty() && old.isEmpty()) {
                    return steps;
                }
            }

            for (int it : old) {
                pq.add(it);
            }
        }

        return steps;
    }

    private static class NodeComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer n1, Integer n2) {
            return n2 - n1;
        }
    }



    public static void main(String[] args) {

    }
}
