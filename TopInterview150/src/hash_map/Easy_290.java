package hash_map;

import java.util.HashMap;
import java.util.Map;

public class Easy_290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        int i = 0;

        if (s.split(" ").length != pattern.length()) {
            return false;
        }

        for (String str: s.split(" ")) {
            char v = pattern.charAt(i);
            if (map.containsKey(v) && !map.get(v).equals(str)) {
                return false;
            } else if (!map.containsKey(v) && map.containsValue(str)) {
                return false;
            } else {
                map.put(v, str);
            }
            i += 1;
        }

        return true;
    }
}
