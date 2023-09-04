package array_string;

import java.util.Arrays;

public class Medium_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        int count = 2 * numRows - 2;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i += 1) {
            sbs[i] = new StringBuilder();
        }

        for (int i = 0; i < n; i += 1) {
            int idx = i % count;
            if (idx >= numRows) {
                idx = count - idx;
            }
            sbs[idx].append(s.charAt(i));
        }

        StringBuilder ans = sbs[0];

        for (int i = 1; i < sbs.length; i += 1) {
            ans.append(sbs[i]);
        }

        return ans.toString();
    }
}
