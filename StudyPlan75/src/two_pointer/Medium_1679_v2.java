package two_pointer;

import java.util.*;

public class Medium_1679_v2 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> matchMap = new HashMap<>();
        int count = 0;

        for (int i: nums) {
            if (matchMap.containsKey(k - i) && k - i > 0) {
                count += 1;
                if (matchMap.get(k - i) > 1) {
                    matchMap.put(k - i, matchMap.get(k - i) - 1);
                } else {
                    matchMap.remove(k - i);
                }
            } else {
                matchMap.put(i, matchMap.getOrDefault(i, 0) + 1);
            }
        }

        return count;
    }
}
