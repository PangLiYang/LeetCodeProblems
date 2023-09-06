package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class Medium_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        if (n <= 1) {
            return n;
        }

        int lp = 0;
        int rp = 1;
        int max = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(lp));

        while (rp < n) {
            char c = s.charAt(rp);

            if (!set.contains(c)) {
                set.add(c);
                rp += 1;
                max = Math.max(max, rp - lp);
            } else {
                set.remove(s.charAt(lp));
                lp += 1;
            }
        }

        return max;
    }
}
