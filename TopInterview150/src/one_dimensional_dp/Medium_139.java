package one_dimensional_dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Medium_139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        return wordBreakHelp(s, wordDict, new HashSet<>());
    }

    private boolean wordBreakHelp(String s, List<String> wordDict, Set<String> dp) {

        if (s.isEmpty()) {
            return true;
        }

        boolean flag = false;
        int size = s.length();

        for (String str : wordDict) {

            if (str.length() > size) {
                continue;
            }

            boolean valid = true;

            for (int i = 0; i < str.length(); i += 1) {
                if (s.charAt(i) != str.charAt(i)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                StringBuilder sb = new StringBuilder(s);
                if (!dp.contains(sb.substring(str.length(), size))) {
                    flag |= wordBreakHelp(sb.substring(str.length(), size), wordDict, dp);
                    dp.add(sb.substring(str.length(), size));
                }
            }
        }

        return flag;
    }
}
