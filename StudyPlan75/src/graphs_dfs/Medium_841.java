package graphs_dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Medium_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        LinkedList<Integer> keys = new LinkedList<>();
        Set<Integer> marked = new HashSet<>();
        keys.addLast(0);

        while (!keys.isEmpty()) {
            int curr = keys.removeFirst();

            if (marked.contains(curr)) {
                continue;
            }

            marked.add(curr);

            for (int i : rooms.get(curr)) {
                if (!marked.contains(i)) {
                    keys.addLast(i);
                }
            }
        }

        return marked.size() == rooms.size();
    }
}
