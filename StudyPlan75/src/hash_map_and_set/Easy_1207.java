package hash_map_and_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Easy_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occ = new HashMap<>();
        Set<Integer> rep = new HashSet<>();

        for (int i : arr) {
            occ.put(i, occ.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: occ.entrySet()) {
            if (rep.contains(entry.getValue())) {
                return false;
            }
            rep.add(entry.getValue());
        }

        return true;
    }
}
