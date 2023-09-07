package matrix;

import java.util.HashSet;
import java.util.Set;

public class Medium_73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();

        for (int i = 0; i < matrix.length; i += 1) {
            for (int j = 0; j < matrix[0].length; j += 1) {
                if (matrix[i][j] == 0) {
                    col.add(i);
                    row.add(j);
                }
            }
        }

        for (int i: col) {
            for (int j = 0; j < matrix[0].length; j += 1) {
                matrix[i][j] = 0;
            }
        }

        for (int j: row) {
            for (int i = 0; i < matrix.length; i += 1) {
                matrix[i][j] = 0;
            }
        }
    }
}
