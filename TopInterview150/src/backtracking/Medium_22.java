package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Medium_22 {

    public List<String> generateParenthesis(int n) {

        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backTrack(0, 0, n, sb, output);

        return output;
    }

    private void backTrack(int rp, int lp, int n, StringBuilder sb, List<String> output) {

        if (lp == n) {
            output.add(sb.toString());
            return;
        }

        if (rp <= lp) {
            sb.append('(');
            backTrack(rp + 1, lp, n, sb, output);
            sb.deleteCharAt(sb.length() - 1);
        } else if (rp == n) {
            sb.append(')');
            backTrack(rp, lp + 1, n, sb, output);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append('(');
            backTrack(rp + 1, lp, n, sb, output);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            backTrack(rp, lp + 1, n, sb, output);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
