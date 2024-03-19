package backtracking;

import java.util.*;

public class Medium_77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> bfs = new LinkedList<>();

        for (int i = 1; i <= n - k + 1; i += 1) {
            List<Integer> appendList = new LinkedList<>();
            appendList.add(i);
            bfs.add(appendList);
        }

        for (int i = 1; i < k; i += 1) {

            int currSize = bfs.size();

            for (int j = 0; j < currSize; j += 1) {
                List<Integer> currList = bfs.removeFirst();
                int start = currList.getLast();

                for (int h = start + 1; h <= n; h += 1) {
                    List<Integer> appendList = new LinkedList<>(currList);
                    appendList.add(h);
                    bfs.add(appendList);
                }
            }
        }

        return bfs;
    }

}
