package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i += 1) {
            int k = -nums[i];
            if (k < 0) {
                break;
            }
            int lp = i + 1;
            int rp = n - 1;

            while (lp < rp) {
                int sum = nums[lp] + nums[rp];
                if (sum < k) {
                    lp += 1;
                } else if (sum > k) {
                    rp -= 1;
                } else {
                    List<Integer> ret = new ArrayList<>();
                    ret.add(nums[i]);
                    ret.add(nums[lp]);
                    ret.add(nums[rp]);
                    ans.add(ret);
                    while (lp < rp && nums[lp] == nums[lp + 1]) {
                        lp += 1;
                    }
                    while (lp < rp && nums[rp] == nums[rp - 1]) {
                        rp -= 1;
                    }
                    lp += 1;
                    rp -= 1;
                }
            }

            while (i < n - 2 && nums[i] == nums[i + 1]) {
                i += 1;
            }
        }

        return ans;
    }
}
