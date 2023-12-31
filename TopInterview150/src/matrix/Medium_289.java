package matrix;

public class Medium_289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                int lives = liveNei(board, m, n, i, j);

                if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
                    board[i][j] = 3;
                }

                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private static int liveNei(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x += 1) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y += 1) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
