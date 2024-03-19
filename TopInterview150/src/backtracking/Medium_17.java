package backtracking;

import java.util.*;

public class Medium_17 {

    public List<String> letterCombinations(String digits) {

        String[] lettersMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> out = new LinkedList<>();

        if (digits.isEmpty()) {
            return out;
        }

        StringBuilder sb = new StringBuilder();

        bt(digits, 0, sb, out, lettersMap);

        return out;
    }

    private void bt(String str, int idx, StringBuilder sb, List<String> out, String[] lettersMap) {
        if (idx == str.length()) {
            out.add(sb.toString());
            return;
        }

        for (char c : lettersMap[str.charAt(idx) - '2'].toCharArray()) {
            sb.append(c);
            bt(str, idx + 1, sb, out, lettersMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
