package bit_manipulation;

public class Easy_136 {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i: nums) {
            result = result ^ i;
        }

        return result;
    }
}
