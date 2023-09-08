package hash_map;

import java.util.HashMap;
import java.util.Map;

public class Easy_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i += 1) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i += 1) {
            char c = ransomNote.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        return true;
    }
}
