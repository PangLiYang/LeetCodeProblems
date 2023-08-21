package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Medium_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] availableInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(result, curr, k, n, availableInt, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr,
                           int chance, int remains, int[] availableInt, int startIndex) {
        if (chance == 0 && remains == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (chance <= 0 || remains <= 0) {
            return;
        }

        for (int i = startIndex; i < availableInt.length; i += 1) {
            int value = availableInt[i];
            curr.add(value);
            backtrack(result, curr, chance - 1,
                    remains - value, availableInt, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
