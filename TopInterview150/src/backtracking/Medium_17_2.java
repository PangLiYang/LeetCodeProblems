package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Medium_17_2 {

    public List<String> letterCombinations(String digits) {

        int end = digits.length();

        if (end == 0) {
            return new LinkedList<>();
        }

        String[] lettersMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> bfs = new LinkedList<>();
        bfs.addLast("");

        for (int i = 0; i < end; i += 1) {
            int n = bfs.size();

            for (int j = 0; j < n; j += 1) {
                StringBuilder sb = new StringBuilder(bfs.removeFirst());

                for (char c : lettersMap[digits.charAt(i) - '2'].toCharArray() ) {
                    sb.append(c);
                    bfs.addLast(sb.toString());
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return bfs;
    }

}
