package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Medium_17 {
    public List<String> letterCombinations(String digits) {
        String[] digitLetters = {"", "", "abc", "def",
                "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        result.add("");

        for (int i = 0; i < digits.length(); i += 1) {
            result = combine(digitLetters[digits.charAt(i) - '0'], result);
        }

        return result;

    }

    private List<String> combine(String digit, List<String> ls) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < digit.length(); i += 1) {
            for (String str: ls) {
                result.add(str + digit.charAt(i));
            }
        }

        return result;
    }
}
