package graphs_bfs;

import java.util.LinkedList;

public class Medium_994 {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int total = 0;
        int rotten = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<int[]> marked = new LinkedList<>();

        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < cols; j += 1) {
                if (grid[i][j] == 2) {
                    marked.add(new int[]{i, j, 0});
                    total += 1;
                } else if (grid[i][j] == 1) {
                    total += 1;
                }
            }
        }

        if (rotten >= total) {
            return 0;
        }

        while (!marked.isEmpty()) {
            int[] curr = marked.removeFirst();
            rotten += 1;
            int currRow = curr[0];
            int currCol = curr[1];
            int time = curr[2];

            if (rotten >= total) {
                return time;
            }

            for (int[] dir : dirs) {
                int adjRow = currRow + dir[0];
                int adjCol = currCol + dir[1];

                if (adjRow >= 0 && adjCol >=0 && adjRow < rows && adjCol < cols && grid[adjRow][adjCol] == 1) {
                    grid[adjRow][adjCol] = 2;
                    marked.add(new int[]{adjRow, adjCol, time + 1});
                }
            }
        }

        return -1;
    }
}
