package sliding_window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hard_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int sizeOfArray = words.length;
        int sizeOfToken = words[0].length();
        int sizeOfPermutation = sizeOfArray * sizeOfToken;

        int lp = 0;
        int rp = sizeOfPermutation;
        StringBuilder sb = new StringBuilder();
        char[] charOfS = s.toCharArray();

        if (s.length() < sizeOfPermutation) {
            return output;
        }

        for (int i = 0; i < rp; i += 1) {
            sb.append(charOfS[i]);
        }

        while (rp <= s.length()) {

            if (isConcat(sb.toString(), sizeOfToken, map)) {
                output.add(lp);
            }

            if (rp == s.length()) {
                break;
            }

            sb.append(charOfS[rp]);
            sb.deleteCharAt(0);

            rp += 1;
            lp += 1;
        }

        return output;
    }

    private boolean isConcat (String str, int sizeOfToken, Map<String, Integer> map) {
        Map<String, Integer> currMap = new HashMap<>();
        for (int i = 0; i < str.length(); i += sizeOfToken) {
            String substr = str.substring(i, i + sizeOfToken);
            currMap.put(substr, currMap.getOrDefault(substr, 0) + 1);
        }

        return currMap.equals(map);
    }
}
