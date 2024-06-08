package bit_manipulation;

public class Medium_201 {

    public int rangeBitwiseAnd(int left, int right) {

        while (right > left) {
            right = right & (right - 1);
        }

        return right;
    }
}
