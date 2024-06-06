package bit_manipulation;

public class Easy_136 {

    public int singleNumber(int[] nums) {

        int ret = 0;

        for (int i : nums) {
            ret = ret ^ i;
        }

        return ret;
    }
}
