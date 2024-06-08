package math;

public class Easy_66 {

    public int[] plusOne(int[] digits) {


        for (int i = digits.length - 1; i >= 0; i -= 1) {

            int curr = digits[i] + 1;

            if (curr <= 9) {
                digits[i] = curr;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] out = new int[digits.length + 1];
        out[0] = 1;

        return out;
    }
}
