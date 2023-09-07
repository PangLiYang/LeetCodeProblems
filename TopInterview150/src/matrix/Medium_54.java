package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int k = 0;

        while(n >= 1 && m >= 1) {
            int[][] newMatrix = new int[n][m];
            for (int i = 0; i < n; i += 1) {
                newMatrix[i] = Arrays.copyOfRange(matrix[i + k], k, matrix[0].length - k);
            }
            outer(list, newMatrix);
            k += 1;
            n -= 2;
            m -= 2;
        }

        return list;
    }

    private void outer(List<Integer> list, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (n == 1 && m == 1) {
            list.add(matrix[0][0]);
            return;
        }

        if (n == 1) {
            for (int i: matrix[0]) {
                list.add(i);
            }
            return;
        }

        if (m == 1) {
            for (int i = 0; i < n; i += 1) {
                list.add(matrix[i][0]);
            }
            return;
        }

        for (int i = 0; i < m ; i += 1) {
            list.add(matrix[0][i]);
        }

        for (int i = 1; i < n - 1 ; i += 1) {
            list.add(matrix[i][m - 1]);
        }

        for (int i = m - 1; i >= 0; i -= 1) {
            list.add(matrix[n - 1][i]);
        }

        for (int i = n - 2; i >= 1; i -= 1) {
            list.add(matrix[i][0]);
        }
    }
}
