package array_string;

import java.util.Arrays;

public class Easy_14_2 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        int idx = 0;
        while (str1.length() > idx && str2.length() > idx) {
            if (str1.charAt(idx) == str2.charAt(idx)) {
                idx += 1;
            } else {
                break;
            }
        }

        return str1.substring(0, idx);
    }
}
