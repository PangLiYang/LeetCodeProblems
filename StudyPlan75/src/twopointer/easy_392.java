package twopointer;

public class easy_392 {
    public boolean isSubsequence(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int startPos = 0;
        char target;

        for (int i = 0; i < s.length(); i += 1) {
            target = s.charAt(i);
            for (int j = startPos; j < t.length(); j += 1) {
                if (t.charAt(j) == target) {
                    sb.append(t.charAt(j));
                    startPos = j + 1;
                    break;
                }
            }
        }

        if (sb.toString().equals(s)) {
            return true;
        }

        return false;
    }
}
