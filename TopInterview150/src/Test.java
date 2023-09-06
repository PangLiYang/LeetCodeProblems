import java.util.*;

public class Test {

    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder();
        int rIdx = 0;
        int dIdx = 0;

        for (int i = 0; i < senate.length(); i += 1) {
            char c = senate.charAt(i);
            if (c == 'R') {
                if (rIdx < 0) {
                    rIdx += 1;
                } else {
                    if (i == senate.length() - 1) {
                        sb.insert(0, c);
                    } else {
                        sb.append(c);
                        dIdx -= 1;
                    }
                }
            } else {
                if (dIdx < 0) {
                    dIdx += 1;
                } else {
                    if (i == senate.length() - 1) {
                        sb.insert(0, c);
                    } else {
                        sb.append(c);
                        rIdx -= 1;
                    }
                }
            }
        }

        String ans = sb.toString();

        if (ans.replace("R", "").equals("")) {
            return "Radiant";
        }

        if (ans.replace("D", "").equals("")) {
            return "Dire";
        }

        return predictPartyVictory(ans);
    }

    public static void main(String[] args) {
        String input = "RRDDD";
        Test tt = new Test();
        System.out.println(tt.predictPartyVictory(input));
    }
}
