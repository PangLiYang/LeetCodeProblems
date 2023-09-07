package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Medium_48 {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int n = size;
        int k = 0;

        while (n > 1) {
            outerRotate(matrix, k);
            k += 1;
            n -= 2;
        }
    }

    private static void outerRotate(int[][] matrix, int k) {
        int n = matrix.length;

        if (n == 1) {
            return;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = k; i < n - k - 1; i += 1) {
            queue.add(matrix[k][i]);
        }

        for (int i = k; i < n - k - 1; i += 1) {
            queue.add(matrix[i][n - k - 1]);
            matrix[i][n - k - 1] = queue.remove();
        }

        for (int i = n - k - 1; i >= k + 1; i -= 1) {
            queue.add(matrix[n - k - 1][i]);
            matrix[n - k - 1][i] = queue.remove();
        }

        for (int i = n - k - 1; i >= k + 1; i -= 1) {
            queue.add(matrix[i][k]);
            matrix[i][k] = queue.remove();
        }

        for (int i = k; i < n - k - 1; i += 1) {
            matrix[k][i] = queue.remove();
        }
    }
}
