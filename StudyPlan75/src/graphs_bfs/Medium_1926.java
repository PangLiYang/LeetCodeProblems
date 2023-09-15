package graphs_bfs;

import java.util.LinkedList;

public class Medium_1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int startRow = entrance[0];
        int startCol = entrance[1];
        maze[startRow][startCol] = '+';

        LinkedList<int[]> marked = new LinkedList<>();
        marked.addLast(new int[]{startRow, startCol, 0});

        while (!marked.isEmpty()) {
            int[] curr = marked.removeFirst();
            int currRow = curr[0];
            int currCol = curr[1];
            int steps = curr[2];


            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && maze[nextRow][nextCol] == '.') {
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1) {
                        return steps + 1;
                    }

                    maze[nextRow][nextCol] = '+';
                    marked.add(new int[]{nextRow, nextCol, steps + 1});
                }
            }
        }

        return -1;
    }
}
