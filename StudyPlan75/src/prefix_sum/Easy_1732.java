package prefix_sum;

public class Easy_1732 {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int end = 0;

        for (int i: gain) {
            end += i;
        }
        int max = end;

        for (int i = 1; i < n + 1; i ++) {
            end -= gain[n - i];
            max = Math.max(max, end);
        }

        return max;
    }
}
