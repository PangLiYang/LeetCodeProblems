package graph_general;

import java.util.*;

public class Medium_399 {
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            double[] res = new double[queries.size()];
            Map<String, Map<String, Double>> map = new HashMap<>();

            for (int i = 0; i < equations.size(); i += 1) {
                List<String> curr = equations.get(i);
                Map<String, Double> front = map.getOrDefault(curr.get(0), new HashMap<>());
                Map<String, Double> back = map.getOrDefault(curr.get(1), new HashMap<>());
                front.put(curr.get(1), values[i]);
                back.put(curr.get(0), 1 / values[i]);
                map.put(curr.get(0), front);
                map.put(curr.get(1), back);
            }

            for (int i = 0; i < queries.size(); i += 1) {
                List<String> curr = queries.get(i);
                String from = curr.get(0);
                String to = curr.get(1);

                if (!map.containsKey(from) || !map.containsKey(to)) {
                    res[i] = -1.0;
                } else {
                    Set<String> vis = new HashSet<>();
                    double[] ans = {-1.0};
                    rec(from, to, map, vis, 1.0, ans);

                    res[i] = ans[0];
                }

            }

            return res;
        }

        private void rec(String from, String to, Map<String, Map<String, Double>> map, Set<String> vis, double curr, double[] ans) {
            if(vis.contains(from)) {
                return;
            }

            vis.add(from);

            if (from.equals(to)) {
                ans[0] = curr;
                return;
            }

            for (Map.Entry<String, Double> entry : map.get(from).entrySet()) {
                rec(entry.getKey(), to, map, vis, curr * entry.getValue(), ans);
            }
        }
    }
}
