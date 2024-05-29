package backtracking;

public class Medium_79 {

    public boolean exist(char[][] board, String word) {

        char[] wordA = word.toCharArray();

        for (int row = 0; row < board.length; row += 1) {
            for (int col = 0; col < board[0].length; col += 1) {
                if (backTrack(row, col, 0, wordA, board)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backTrack (int row, int col, int idx, char[] word, char[][] board) {

        boolean cond = false;

        if (board[row][col] == word[idx]) {

            if (idx + 1 == word.length) {
                return true;
            }

            board[row][col] = '.';

            if (row - 1 >= 0) {
                cond = backTrack(row - 1, col, idx + 1, word, board);
            }

            if (row + 1 < board.length) {
                cond = cond || backTrack(row + 1, col, idx + 1, word, board);
            }

            if (col - 1 >= 0) {
                cond = cond || backTrack(row, col - 1, idx + 1, word, board);
            }

            if (col + 1 < board[0].length) {
                cond = cond || backTrack(row, col + 1, idx + 1, word, board);
            }

            board[row][col] = word[idx];
        }

        return cond;
    }
}
