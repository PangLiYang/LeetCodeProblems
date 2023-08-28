package bit_manipulation;

public class Easy_338_2 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i += 1) {
            result[i] = result[i >> 1] + (i % 2);
        }
        return result;
    }
}
