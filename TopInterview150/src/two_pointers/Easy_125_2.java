package two_pointers;

public class Easy_125_2 {
    public boolean isPalindrome(String s) {
        String sl = s.toLowerCase();
        int lp = 0;
        int rp = sl.length() - 1;

        while (lp < rp) {
            while (lp < rp && isNotValid(sl.charAt(lp))) {
                lp += 1;
            }
            while (lp < rp && isNotValid(sl.charAt(rp))) {
                rp -= 1;
            }
            if (sl.charAt(lp) != sl.charAt(rp)) {
                return false;
            }
            lp += 1;
            rp -= 1;
        }

        return true;
    }

    private static boolean isNotValid(char c) {
        if (c <= 'z' && c >= 'a') {
            return false;
        }
        if (c <= '9' && c >= '0') {
            return false;
        }

        return true;
    }
}
