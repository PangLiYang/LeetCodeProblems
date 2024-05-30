package binary_search;

public class Medium_74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rStart = 0;
        int rEnd = matrix.length - 1;
        int rIdx = 0;

        while (rStart <= rEnd) {
            rIdx = rStart + (rEnd - rStart) / 2;
            int curr = matrix[rIdx][0];

            if (curr == target) {
                return true;
            } else if (curr > target) {
                rEnd = rIdx - 1;
            } else if (rIdx + 1 < matrix.length && matrix[rIdx + 1][0] <= target) {
                rStart = rIdx + 1;
            } else {
                break;
            }
        }

        int cStart = 0;
        int cEnd = matrix[rIdx].length - 1;

        while (cStart <= cEnd) {
            int idx = cStart + (cEnd - cStart) / 2;
            int curr = matrix[rIdx][idx];

            if (curr == target) {
                return true;
            } else if (curr < target) {
                cStart = idx + 1;
            } else {
                cEnd = idx - 1;
            }
        }

        return false;
    }
}
