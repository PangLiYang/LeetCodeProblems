package hash_map_and_set;

import java.util.HashMap;
import java.util.Map;

public class Medium_2352_2 {
    public int equalPairs(int[][] grid) {
        int n = grid[0].length;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i += 1) {
            StringBuilder sb = new StringBuilder();
            for (int j: grid[i]) {
                sb.append(j);
                sb.append(' ');
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < n; i += 1) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j += 1) {
                sb.append(grid[j][i]);
                sb.append(' ');
            }
            String s = sb.toString();
            ans += map.getOrDefault(s, 0);
        }

        return ans;
    }
}
