package math;

public class Easy_9 {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        if (x != 0 && x % 10 == 0) {
            return false;
        }

        int rev = 0;

        while (rev < x) {
            rev = 10 * rev + x % 10;
            x /= 10;
        }

        return x == rev || x == rev / 10;
    }
}
