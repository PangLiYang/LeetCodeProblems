package graph_general;

import java.util.ArrayList;
import java.util.List;

public class Medium_133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Node[] vis = new Node[101];

        return dfs(node, vis);
    }

    private Node dfs(Node node, Node[] vis) {
        if (vis[node.val] != null) {
            return vis[node.val];
        }

        vis[node.val] = new Node(node.val);

        for (Node n : node.neighbors) {
            vis[node.val].neighbors.add(dfs(n, vis));
        }

        return vis[node.val];
    }

}
