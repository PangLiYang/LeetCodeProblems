package two_pointers;

public class Easy_392 {
    public boolean isSubsequence(String s, String t) {

        int sl = s.length();
        int tl = t.length();

        if (sl == 0) {
            return true;
        }

        if (tl == 0 || tl < sl) {
            return false;
        }

        int sp = 0;

        for (int i = 0; i < t.length(); i += 1) {

            if (t.charAt(i) == s.charAt(sp)) {
                sp += 1;
            }

            if (sp == sl) {
                return true;
            }
        }

        return false;
    }
}
