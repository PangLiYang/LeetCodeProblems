package backtracking;

import java.util.Arrays;

public class Hard_52 {

    public int totalNQueens(int n) {

        int[] output = {0};
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backTrack(0, board, output);

        return output[0];
    }

    private void backTrack(int row, char[][] board, int[] output) {

        if (row >= board.length) {
            output[0] += 1;
            return;
        }

        for (int col = 0; col < board.length; col += 1) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backTrack(row + 1, board, output);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
