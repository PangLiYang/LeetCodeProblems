package queue;

public class Medium_649_3 {
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
                    sb.append(c);
                    dIdx -= 1;
                }
            } else {
                if (dIdx < 0) {
                    dIdx += 1;
                } else {
                    sb.append(c);
                    rIdx -= 1;
                }
            }
        }

        while (rIdx < 0) {
            sb.insert(0, 'D');
            sb.deleteCharAt(sb.length() - 1);
            rIdx += 1;
        }

        while (dIdx < 0) {
            sb.insert(0, 'R');
            sb.deleteCharAt(sb.length() - 1);
            dIdx += 1;
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
}
