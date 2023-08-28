package bit_manipulation;

public class Easy_338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i += 1) {
            res[i] = countSupport(i);
        }

        return res;
    }

    private static int countSupport(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 2;
            n /= 2;
        }

        return res;
    }
}
