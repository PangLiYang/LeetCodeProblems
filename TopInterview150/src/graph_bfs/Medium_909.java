package graph_bfs;

import java.util.Arrays;
import java.util.LinkedList;

public class Medium_909 {

    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        int n2 = n * n;

        int[] steps = new int[n2 + 1];
        Arrays.fill(steps, Integer.MAX_VALUE);

        LinkedList<Integer> bfs = new LinkedList<>();
        bfs.addLast(1);
        steps[1] = 0;

        while (!bfs.isEmpty()) {

            int curr = bfs.removeFirst();
            int currSteps = steps[curr];

            for (int i = 1; curr + i <= n2 && i <= 6; i += 1) {
                int[] map = mapping(n, curr + i);

                int next = curr + i;

                if (board[map[0]][map[1]] != -1) {
                    next = board[map[0]][map[1]];
                }

                if (1 + currSteps < steps[next]) {
                    steps[next] = 1 + currSteps;
                    bfs.addLast(next);
                }
            }
        }

        if (steps[n2] == Integer.MAX_VALUE) {
            return -1;
        }

        return steps[n2];
    }

    private static int[] mapping(int n, int input) {

        int x = (input - 1) / n;
        x = n - x - 1;

        int y = input % n;

        if (y == 0) {
            y = n;
        }

        if ((n - x) % 2 == 0) {
            y = n - y;
        } else {
            y = y - 1;
        }

        return new int[]{x, y};
    }
}
