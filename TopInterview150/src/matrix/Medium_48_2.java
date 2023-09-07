package matrix;

public class Medium_48_2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i += 1) {
            for (int j = i + 1; j < n ; j += 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < n / 2 ; j += 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
