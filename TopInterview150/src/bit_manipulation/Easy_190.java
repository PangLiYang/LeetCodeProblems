package bit_manipulation;

public class Easy_190 {

    public int reverseBits(int num) {

        int ret = 0;

        for (int i = 0; i < 32; i += 1) {
            ret = ret << 1;
            ret = ret | (num & 1);
            num = num >> 1;
        }

        return ret;
    }
}
