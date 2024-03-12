package graph_bfs;

import java.util.*;

public class Medium_433 {
    public int minMutation(String startGene, String endGene, String[] bank) {

        if (startGene.equals(endGene)) {
            return 0;
        }

        Map<String, List<String>> graph = new HashMap<>();

        for (String str : bank) {

            List<String> temp = new LinkedList<>();

            for (String next : bank) {
                if (isMut(str, next)) {
                    temp.add(next);
                }
            }

            if (!temp.isEmpty()) {
                graph.put(str, temp);
            }
        }

        List<String> temp = new LinkedList<>();

        for (String next : bank) {
            if (isMut(startGene, next)) {
                temp.add(next);
            }
        }

        if (!temp.isEmpty()) {
            graph.put(startGene, temp);
        }

        LinkedList<String> bfs = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        bfs.addLast(startGene);
        vis.add(startGene);
        int step = 0;

        while (!bfs.isEmpty()) {

            int n = bfs.size();
            step += 1;

            for (int i = 0; i < n; i += 1) {

                String curr = bfs.removeFirst();

                if (!graph.containsKey(curr)) {
                    continue;
                }

                for (String dest : graph.get(curr)) {

                    if (dest.equals(endGene)) {
                        return step;
                    }

                    if (!vis.contains(dest)) {
                        bfs.addLast(dest);
                        vis.add(dest);
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isMut(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i += 1) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff += 1;
            }
        }

        return diff == 1;
    }
}
