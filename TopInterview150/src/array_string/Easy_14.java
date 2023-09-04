package array_string;

public class Easy_14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int m = strs[0].length();

        for (int i = 0; i < m; i += 1) {
            char target = strs[0].charAt(i);
            for (String s: strs) {
                if (s.length() <= i) {
                    return sb.toString();
                }
                if (s.charAt(i) != target) {
                    return sb.toString();
                }
            }
            sb.append(target);
        }

        return sb.toString();
    }
}
