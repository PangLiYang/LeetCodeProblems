package graphs_dfs;

import java.util.*;

public class Medium_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Edge>> adjList = new HashMap<>();
        double[] results = new double[queries.size()];

        for (int i = 0; i < equations.size(); i += 1) {
            List<String> target = equations.get(i);
            String p = target.get(0);
            String q = target.get(1);
            double v = values[i];

            if (!adjList.containsKey(p)) {
                adjList.put(p, new ArrayList<>());
            }

            if (!adjList.containsKey(q)) {
                adjList.put(q, new ArrayList<>());
            }

            adjList.get(p).add(new Edge(q, v));
            adjList.get(q).add(new Edge(p, 1.0 / v));
        }

        for (int i = 0; i < queries.size(); i += 1) {
            Set<String> record = new HashSet<>();
            List<String> target = queries.get(i);
            String p = target.get(0);
            String q = target.get(1);

            if (!adjList.containsKey(p) || !adjList.containsKey(q)) {
                results[i] = -1;
                continue;
            }

            results[i] = dfs(adjList, record, p, q, 1);
        }

        return results;
    }

    private double dfs(Map<String, List<Edge>> adjList, Set<String> record, String p, String q, double v) {

        if (p.equals(q)) {
            return v;
        }

        if (record.contains(p)) {
            return -1;
        }

        record.add(p);

        for (Edge edge : adjList.get(p)) {
            double result = dfs(adjList, record, edge.name, q, edge.val * v);
            if (result > 0) {
                return result;
            }
        }

        return -1;
    }

    private static class Edge {
        String name;
        double val;

        public Edge(String name, double val) {
            this.name = name;
            this.val = val;
        }
    }
}
