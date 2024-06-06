package bit_manipulation;

public class Easy_67 {

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int x = a.length() - 1, y = b.length() - 1, carry = 0;

        while (x >= 0 || y >= 0) {
            if (x >= 0) {
                carry += a.charAt(x) - '0';
                x -= 1;
            }
            if (y >= 0) {
                carry += b.charAt(y) - '0';
                y -= 1;
            }
            sb.append(carry % 2);
            carry = carry / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
