package array_string;

public class Medium_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];

        for (int c : citations) {
            int i = Math.min(c, n);
            freq[i] += 1;
        }

        int count = 0;

        for (int i = n; i >= 0; i -= 1) {
            count += freq[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }
}
