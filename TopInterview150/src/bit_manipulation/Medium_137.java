package bit_manipulation;

public class Medium_137 {
    public int singleNumber(int[] nums) {

        int ret = 0;

        for (int i = 0; i < 32; i += 1) {
            int curr = 0;
            for (final int num : nums) {
                curr += (num >> i) & 1;
            }
            curr = curr % 3;
            ret = ret | curr << i;
        }

        return ret;
    }
}
