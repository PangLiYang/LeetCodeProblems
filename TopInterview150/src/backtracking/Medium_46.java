package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Medium_46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> out = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];

        bt(nums, vis, new ArrayList<>(), out);

        return out;
    }

    private void bt(int[] nums, boolean[] vis, List<Integer> curr, List<List<Integer>> out) {

        if (curr.size() == nums.length) {
            out.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < vis.length; i += 1) {
            if(!vis[i]) {
                curr.addLast(nums[i]);
                vis[i] = true;
                bt(nums, vis, curr, out);
                curr.removeLast();
                vis[i] = false;
            }
        }
    }

}
