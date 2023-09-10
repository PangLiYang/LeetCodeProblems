package intervals;

import java.util.ArrayList;
import java.util.List;

public class Easy_228_2 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int idx = 0;

        while (idx < nums.length) {
            int begin, last;
            begin = nums[idx];
            while (idx + 1 < nums.length && nums[idx + 1] == nums[idx] + 1) {
                idx += 1;
            }
            last = nums[idx];
            if (begin == last) {
                ans.add(begin + "");
            } else {
                ans.add(begin + "->" + last);
            }
            idx += 1;
        }

        return ans;
    }
}
