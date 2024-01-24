package graph_general;

public class Medium_200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[0].length; j += 1) {
                if (grid[i][j] == '1') {
                    count += 1;
                    recEliminate(grid, i , j, dirs);
                }
            }
        }

        return count;
    }

    private void recEliminate (char[][] grid, int i, int j, int[][] dirs) {
        grid[i][j] = '0';

        for (int[] dir : dirs) {
            int ii = i + dir[0];
            int jj = j + dir[1];

            if (isValid(grid, ii, jj)) {
                if (grid[ii][jj] == '1') {
                    recEliminate(grid, ii, jj, dirs);
                }
            }
        }
    }

    private boolean isValid(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length) {
            if (j >= 0 && j < grid[0].length) {
                return true;
            }
        }

        return false;
    }
}
