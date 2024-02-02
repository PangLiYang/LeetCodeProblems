package graph_general;

public class Medium_130 {
    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i += 1) {
            for (int j = 0; j < board[0].length; j += 1) {
                if (board[i][j] == 'O') {
                    if(dfsSolve(i, j, board)) {
                        flipTo(board);
                    } else {
                        flipBack(board);
                    }
                }
            }
        }
    }

    private boolean dfsSolve(int x, int y, char[][] board) {

        if (!isValid(x, y, board)) {
            return false;
        }

        if (board[x][y] == 'X' || board[x][y] == 'T') {
            return true;
        }

        board[x][y] = 'T';

        if (dfsSolve(x - 1, y, board) && dfsSolve(x + 1, y, board) && dfsSolve(x, y - 1, board) && dfsSolve(x, y + 1, board)) {
            return true;
        } else {
            // board[x][y] = 'O';
            return false;
        }
    }

    private boolean isValid(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length) {
            return false;
        }

        if (y < 0 || y >= board[0].length) {
            return false;
        }

        return true;
    }

    private void flipBack(char[][] board) {
        for (int i = 0; i < board.length; i += 1) {
            for (int j = 0; j < board[0].length; j += 1) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void flipTo(char[][] board) {
        for (int i = 0; i < board.length; i += 1) {
            for (int j = 0; j < board[0].length; j += 1) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
