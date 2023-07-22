package hash_map_and_set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Medium_2352_2 {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> compMap = new HashMap<>();
        int count = 0;

        for (int[] slice : grid) {
            String str = Arrays.toString(slice);
            compMap.put(str, compMap.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < grid.length; i += 1) {
            int[] target = new int[grid.length];
            for (int j = 0; j < grid.length; j += 1) {
                target[j] = grid[j][i];
            }

            String targetStr = Arrays.toString(target);

            if (compMap.containsKey(targetStr)) {
                count += compMap.get(targetStr);
            }
        }

        return count;
    }
}
