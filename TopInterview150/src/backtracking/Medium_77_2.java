package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Medium_77_2 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> out = new ArrayList<>();

        bt(n, k, 0, new ArrayList<>(), out);

        return out;
    }

    private void bt(int n, int k, int tail, List<Integer> curr, List<List<Integer>> out) {
        if (curr.size() == k) {
            out.add(new ArrayList<>(curr));
            return;
        }

        for (int i = tail + 1; i <= n; i += 1) {
            curr.addLast(i);
            bt(n, k, i, curr, out);
            curr.removeLast();
        }
    }

}
