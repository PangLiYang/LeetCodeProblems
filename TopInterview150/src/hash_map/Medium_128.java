package hash_map;

import java.util.HashSet;
import java.util.Set;

public class Medium_128 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = 0;

        if (n == 0 || n == 1) {
            return n;
        }

        Set<Integer> set = new HashSet<>();

        for (int i: nums) {
            set.add(i);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int count = 1;
                while (set.contains(cur + 1)) {
                    count += 1;
                    cur += 1;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
