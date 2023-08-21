package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Medium_17_2 {
    public List<String> letterCombinations(String digits) {
        String[] lettersMap = {"abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backTrack(result, new StringBuilder(), digits, lettersMap, 0);
        return result;
    }

    private void backTrack(List<String> ls, StringBuilder sb, String digits, String[] lettersMap, int idx) {
        if (idx == digits.length()) {
            ls.add(sb.toString());
            return;
        }

        int number = digits.charAt(idx) - '0';
        String numberStr = lettersMap[number - 2];

        for (int i = 0; i < numberStr.length(); i += 1) {
            sb.append(numberStr.charAt(i));
            backTrack(ls, sb, digits, lettersMap, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
