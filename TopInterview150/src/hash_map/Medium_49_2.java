package hash_map;

import java.util.*;

public class Medium_49_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String afterSort = new String(arr);

            if (!map.containsKey(afterSort)) {
                map.put(afterSort, new ArrayList<>());
            }

            map.get(afterSort).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
