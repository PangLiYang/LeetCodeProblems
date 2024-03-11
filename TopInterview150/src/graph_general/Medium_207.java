package graph_general;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Medium_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> gMap = new HashMap<>();
        int[] locks = new int[numCourses];

        for (int[] pre : prerequisites) {
            int take = pre[0];
            int past = pre[1];
            locks[take] += 1;
            List<Integer> currList = gMap.getOrDefault(past, new LinkedList());
            currList.add(take);
            gMap.put(past, currList);
        }

        LinkedList<Integer> bfs = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i += 1) {
            if (locks[i] == 0) {
                count += 1;
                bfs.addLast(i);
            }
        }

        while (!bfs.isEmpty()) {
            int curr = bfs.removeFirst();

            if (gMap.containsKey(curr)) {
                for (int adj : gMap.get(curr)) {
                    locks[adj] -= 1;

                    if (locks[adj] == 0) {
                        count += 1;
                        bfs.addLast(adj);
                    }
                }
            }
        }

        return count == numCourses? true: false;
    }
}
