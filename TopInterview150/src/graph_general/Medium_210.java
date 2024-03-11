package graph_general;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Medium_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graphMap = new HashMap<>();
        int[] locks = new int[numCourses];
        int[] out = new int[numCourses];

        for (int[] pre : prerequisites) {
            int firstTake = pre[1];
            int toTake = pre[0];
            locks[toTake] += 1;

            List<Integer> curr = graphMap.getOrDefault(firstTake, new LinkedList<>());
            curr.add(toTake);
            graphMap.put(firstTake, curr);
        }

        LinkedList<Integer> bfs = new LinkedList<>();

        for (int i = 0; i < locks.length; i += 1) {
            if (locks[i] == 0) {
                bfs.addLast(i);
            }
        }

        int idx = 0;

        while (!bfs.isEmpty()) {
            int curr = bfs.removeFirst();
            out[idx] = curr;
            idx += 1;

            if (graphMap.containsKey(curr)) {

                for (int next : graphMap.get(curr)) {
                    locks[next] -= 1;

                    if (locks[next] == 0) {
                        bfs.addLast(next);
                    }
                }
            }
        }

        return idx == numCourses ? out : new int[0];
    }
}
