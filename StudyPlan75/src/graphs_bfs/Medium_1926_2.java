package graphs_bfs;

import java.util.LinkedList;

public class Medium_1926_2 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        LinkedList<int[]> qu = new LinkedList<>();
        qu.addLast(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int step = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i += 1) {
                int[] cur = qu.removeFirst();
                int x = cur[0];
                int y = cur[1];

                if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                    if (step != 0) {
                        return step;
                    }
                }

                for (int[] dir : directions) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];

                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == '.') {
                        qu.addLast(new int[]{xx, yy});
                        maze[xx][yy] = '+';
                    }
                }

            }
            step += 1;
        }

        return -1;
    }
}
