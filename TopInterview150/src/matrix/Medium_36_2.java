package matrix;

import java.util.HashSet;
import java.util.Set;

public class Medium_36_2 {
    public boolean isValidSudoku(char[][] board) {
        int n = board[0].length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < n; j += 1) {
                char target = board[i][j];
                if (target != '.') {
                    if (!set.add(target + "inRow" + i) ||
                            !set.add(target + "inCol" + j) ||
                            !set.add(target + "inSub" + i / 3 + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
