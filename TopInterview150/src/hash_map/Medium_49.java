package hash_map;

import java.util.*;

public class Medium_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<int[], List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] arr = new int[26];
            for (char c: str.toCharArray()) {
                arr[c - 'a'] += 1;
            }

            boolean exist = false;
            for (Map.Entry<int[], List<String>> entry: map.entrySet()) {
                if (Arrays.equals(entry.getKey(), arr)) {
                    entry.getValue().add(str);
                    exist = true;
                }
            }

            if (!exist) {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(arr, list);
            }
        }

        for (Map.Entry<int[], List<String>> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;

    }
}
