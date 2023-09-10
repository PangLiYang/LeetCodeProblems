package hash_map;

import java.util.HashMap;
import java.util.Map;

public class Easy_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i += 1) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }

            map.put(target - nums[i], i);
        }

        return null;
    }
}
