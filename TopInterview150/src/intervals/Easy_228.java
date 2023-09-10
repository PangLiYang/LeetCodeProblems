package intervals;

import java.util.ArrayList;
import java.util.List;

public class Easy_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        if (nums.length == 0) {
            return list;
        }

        int lp = 0;
        int rp = 1;
        int cur = nums[lp];

        while (rp < nums.length) {
            if (nums[rp] == cur + 1) {
                cur += 1;
                rp += 1;
            } else {
                if (lp == rp - 1) {
                    list.add("" + nums[lp]);
                } else {
                    list.add(nums[lp] + "->" + nums[rp - 1]);
                }
                lp = rp;
                cur = nums[rp];
                rp += 1;
            }
        }

        if (lp == rp - 1) {
            list.add("" + nums[lp]);
        } else {
            list.add(nums[lp] + "->" + nums[rp - 1]);
        }

        return list;
    }
}
