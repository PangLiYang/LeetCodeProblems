package matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Medium_36 {
    public boolean isValidSudoku(char[][] board) {

        int n = board[0].length;

        if (!isValid(board)) {
            System.out.println("Error here!");
            return false;
        }

        for (int c = 0; c < n; c += 3) {
            for (int r = 0; r < n; r += 3) {
                char[][] sub = new char[3][3];
                for (int i = 0; i < 3; i += 1) {
                    sub[i] = Arrays.copyOfRange(board[r + i], c, c + 3);
                }
                if (!subIsVaild(sub)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(char[][] board) {
        int n = board[0].length;
        Set<Character> set;

        for (int i = 0; i < n; i += 1) {
            set = new HashSet<>();
            for (char c: board[i]) {
                if (set.contains(c)) {
                    return false;
                } else if (c != '.') {
                    set.add(c);
                }
            }
        }

        for (int i = 0; i < n; i += 1) {
            set = new HashSet<>();
            for (int j = 0; j < n; j += 1) {
                char c = board[j][i];
                if (set.contains(c)) {
                    return false;
                } else if (c != '.') {
                    set.add(c);
                }
            }
        }

        return true;
    }

    private static boolean subIsVaild(char[][] board) {
        int n = board[0].length;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < n; i += 1) {
            for (char c: board[i]) {
                if (set.contains(c)) {
                    return false;
                } else if (c != '.') {
                    set.add(c);
                }
            }
        }

        return true;
    }
}
