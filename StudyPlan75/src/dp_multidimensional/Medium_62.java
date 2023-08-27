package dp_multidimensional;

public class Medium_62 {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int downSteps = m - 1;
        int rightSteps = n - 1;

        if (downSteps < rightSteps) {
            int temp = downSteps;
            downSteps = rightSteps;
            rightSteps = temp;
        }

        double dePermutation = 1;
        int otherIdx = 1;

        for (int i = downSteps + 1; i <= downSteps + rightSteps; i += 1) {
            dePermutation *= i;
            dePermutation /= otherIdx;
            otherIdx += 1;
        }

        return (int) Math.round(dePermutation);
    }
}
