package graphs_dfs;

import java.util.*;

public class Medium_1466 {
    public int minReorder(int n, int[][] connections) {
        boolean[] vi = new boolean[n];
        List<List<Integer>> al = new ArrayList<>();

        for (int i = 0; i < n; i += 1) {
            al.add(new ArrayList<>());
        }
        for (int[] conn : connections) {
            al.get(conn[0]).add(conn[1]);
            al.get(conn[1]).add(-conn[0]);
        }
        return dfs(al, vi, 0);
    }

    private int dfs(List<List<Integer>> al, boolean[] vi, int from) {
        int change = 0;
        vi[from] = true;

        for (int to : al.get(from)) {
            if(!vi[Math.abs(to)]) {
                change += dfs(al, vi, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    }
}
