package graphs_dfs;

import java.util.List;

public class Medium_841_2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {

        visited[room] = true;
        for (int i : rooms.get(room)) {
            if (!visited[i]) {
                dfs(i, rooms, visited);
            }
        }
    }
}
