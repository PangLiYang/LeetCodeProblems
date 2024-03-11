package graph_general;

import java.util.*;

public class Medium_207_2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> gMap = new HashMap<>();

        for (int[] pre : prerequisites) {
            int take = pre[0];
            int past = pre[1];
            List<Integer> currList = gMap.getOrDefault(past, new LinkedList());
            currList.add(take);
            gMap.put(past, currList);
        }


        for (int i = 0; i < numCourses; i += 1) {
            if (gMap.containsKey(i)) {
                Set<Integer> vis = new HashSet<>();

                if (!dfsTest(gMap, vis, i)) {
                    return false;
                }

            }
        }

        return true;
    }

    private boolean dfsTest(Map<Integer, List<Integer>> gMap, Set<Integer> vis, int curr) {

        if (vis.contains(curr)) {
            return false;
        }

        vis.add(curr);

        if (!gMap.containsKey(curr)) {
            vis.remove(curr);
            return true;
        }

        for (int i : gMap.get(curr)) {
            if (!dfsTest(gMap, vis, i)) {
                return false;
            }
        }

        vis.remove(curr);
        return true;
    }
}
