package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Hard_76 {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int minSize = Integer.MAX_VALUE;

        int startPos = 0;
        int lp = 0;
        int rp = 0;
        int count = t.length();
        char[] charOfS = s.toCharArray();
        char[] charOfT = t.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : charOfT) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (rp < s.length()) {
            char c = charOfS[rp];

            if (map.containsKey(c) && map.get(c) > 0) {
                count -= 1;
            }

            map.put(c, map.getOrDefault(c, 0) - 1);
            rp += 1;

            while (count == 0) {
                char cos = charOfS[lp];

                if (rp - lp < minSize) {
                    startPos = lp;
                    minSize = rp - lp;
                }

                map.put(cos, map.getOrDefault(cos, 0) + 1);
                if (map.get(cos) > 0) {
                    count += 1;
                }
                lp += 1;
            }
        }

        if (minSize != Integer.MAX_VALUE) {
            return s.substring(startPos, startPos + minSize);
        }

        return "";
    }
}
