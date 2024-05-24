package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> out = new ArrayList<>();

        bt(candidates, target, 0, new ArrayList<>(), out);

        return out;
    }

    private void bt(int[] candidates, int sum, int tail, List<Integer> curr, List<List<Integer>> out) {

        if (sum == 0) {
            out.add(new ArrayList<>(curr));
            return;
        }

        for (int i = tail; i < candidates.length; i += 1) {
            int candidate = candidates[i];
            if (sum - candidate >= 0) {
                sum -= candidate;
                curr.addLast(candidate);
                bt(candidates, sum, i, curr, out);
                curr.removeLast();
                sum += candidate;
            }
        }
    }
}


