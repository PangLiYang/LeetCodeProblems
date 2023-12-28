import java.util.*;

public class Test {

    private static class Node {
        char name;
        boolean isVisited;
        Node parent;

        Node(char name) {
            this.name = name;
            this.isVisited = false;
            this.parent = null;
        }
    }

    private static boolean isSpod(Map<Node, LinkedList<Node>> adjList, Node s, Node w) {

        w.isVisited = true;

        LinkedList<Node> bfs = new LinkedList<>();
        bfs.addLast(s);
        s.isVisited = true;
        int iter = 1;

        while (!bfs.isEmpty()) {
            int nextIter = 0;

            for (int i = 0; i < iter; i += 1) {
                Node curr = bfs.removeFirst();

                for (Node nodes : adjList.get(curr)) {
                    if (!nodes.isVisited) {
                        nodes.isVisited = true;
                        bfs.addLast(nodes);
                        nextIter += 1;
                    }
                }
            }

            iter = nextIter;
        }

        for (Map.Entry<Node, LinkedList<Node>> entry : adjList.entrySet()) {
            if (!entry.getKey().isVisited) {
                return true;
            }
        }

        return false;
    }

    private static Node getSpod(Map<Node, LinkedList<Node>> adjList, Node u, Node w) {

        LinkedList<Node> bfs = new LinkedList<>();
        bfs.addLast(u);
        u.isVisited = true;
        boolean earlyBreak = false;
        boolean findSingleton = false;
        int iter = 1;

        while (!bfs.isEmpty()) {

            int nextIter = 0;

            for (int i = 0; i < iter; i += 1) {
                Node curr = bfs.removeFirst();
                boolean noneNext = true;

                for (Node nodes : adjList.get(curr)) {

                    if (!nodes.isVisited) {
                        nodes.parent = curr;
                        noneNext = false;
                        if (nodes.equals(w)) {
                            earlyBreak = true;
                        }
                        nodes.isVisited = true;
                        bfs.addLast(nodes);
                        nextIter += 1;
                    }
                }

                if (noneNext) {
                    findSingleton = true;
                }
            }

            if (findSingleton) {
                return bfs.removeFirst().parent;
            }

            iter = nextIter;

            if(earlyBreak) {
                System.out.println("early break");
                break;
            }
        }

        return null;
    }

    private static void case1() {

        Map<Node, LinkedList<Node>> adjList = new HashMap<>();
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');
        Node i = new Node('i');


        adjList.put(a, new LinkedList<>());
        adjList.get(a).add(b);
        adjList.get(a).add(i);

        adjList.put(i, new LinkedList<>());
        adjList.get(i).add(a);
        adjList.get(i).add(d);

        adjList.put(b, new LinkedList<>());
        adjList.get(b).add(a);
        adjList.get(b).add(c);

        adjList.put(c, new LinkedList<>());
        adjList.get(c).add(b);
        adjList.get(c).add(d);
        adjList.get(c).add(e);

        adjList.put(d, new LinkedList<>());
        adjList.get(d).add(a);
        adjList.get(d).add(c);

        adjList.put(g, new LinkedList<>());
        adjList.get(g).add(f);
        adjList.get(g).add(h);

        adjList.put(f, new LinkedList<>());
        adjList.get(f).add(e);
        adjList.get(f).add(g);

        adjList.put(e, new LinkedList<>());
        adjList.get(e).add(c);
        adjList.get(e).add(f);
        adjList.get(e).add(h);

        adjList.put(h, new LinkedList<>());
        adjList.get(h).add(e);
        adjList.get(h).add(g);

        Node spod = getSpod(adjList, a, g);
        if (spod != null) {
            System.out.println(spod.name);
        } else {
            System.out.println("No spod!");
        }
    }

    private static void case2() {

        Map<Node, LinkedList<Node>> adjList = new HashMap<>();
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');


        adjList.put(a, new LinkedList<>());
        adjList.get(a).add(g);
        adjList.get(a).add(d);

        adjList.put(b, new LinkedList<>());
        adjList.get(b).add(g);
        adjList.get(b).add(c);

        adjList.put(c, new LinkedList<>());
        adjList.get(c).add(b);
        adjList.get(c).add(d);
        adjList.get(c).add(e);
        adjList.get(c).add(f);

        adjList.put(d, new LinkedList<>());
        adjList.get(d).add(a);
        adjList.get(d).add(c);

        adjList.put(e, new LinkedList<>());
        adjList.get(e).add(c);

        adjList.put(f, new LinkedList<>());
        adjList.get(f).add(c);

        adjList.put(g, new LinkedList<>());
        adjList.get(g).add(a);
        adjList.get(g).add(b);

//        System.out.println(isSpod(adjList, a, c));

        Node spod = getSpod(adjList, a, e);
        if (spod != null) {
            System.out.println(spod.name);
        } else {
            System.out.println("No spod!");
        }
    }

    public static void main(String[] args) {

        case1();
        case2();
    }
}
