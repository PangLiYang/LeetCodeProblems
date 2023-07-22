package hash_map_and_set;

import java.util.Arrays;

public class Medium_2352 {
    public int equalPairs(int[][] grid) {
        int count = 0;

        if (grid.length == 1) {
            return 1;
        }

        for (int i = 0; i < grid.length; i += 1) {
            int[] comp = grid[i];
            for (int j = 0; j < grid.length; j += 1) {
                int[] target = new int[grid.length];
                for (int z = 0; z < grid.length; z += 1) {
                    target[z] = grid[z][j];
                }

                if (Arrays.equals(comp, target)) {
                    count += 1;
                }
            }
        }

        return count;
    }
}
