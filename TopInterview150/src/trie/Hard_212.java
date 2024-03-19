package trie;

import java.util.*;

public class Hard_212 {

    public List<String> findWords(char[][] board, String[] words) {

        List<String> out = new LinkedList<>();

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Trie trie = new Trie();

        Node root = trie.root;

        for (String str : words) {
            trie.addWord(str);
        }

        for (int i = 0; i < board.length; i += 1) {
            for (int j = 0; j < board[0].length; j += 1) {

                int[] coord = {i, j};

                dfsTrie(coord, board, root, out, dirs);
            }
        }

        return out;
    }

    private void dfsTrie(int[] coord, char[][]board, Node curr, List<String> out, int[][] dirs) {

        int x = coord[0];
        int y = coord[1];
        char c = board[x][y];
        int idx = c - 'a';

        if (c == '*' || curr.children[idx] == null) {
            return;
        }

        curr = curr.children[idx];

        if (curr.token != null) {
            out.add(curr.token);
            curr.token = null;
        }

        board[x][y] = '*';

        for (int[] dir : dirs) {
            int x2 = x + dir[0];
            int y2 = y + dir[1];

            if (x2 < board.length && x2 >= 0 && y2 < board[0].length && y2 >= 0) {

                int[] nextCoord = {x2, y2};
                dfsTrie(nextCoord, board, curr, out, dirs);
            }
        }

        board[x][y] = c;
    }

    private class Trie {

        final Node root;

        public Trie() {
            root = new Node();
        }

        public void addWord(String str) {

            Node curr = root;

            for (char c : str.toCharArray()) {
                int idx = c - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.token = str;
        }

        public boolean match(String str) {
            Node curr = root;

            for (char c : str.toCharArray()) {
                int idx = c - 'a';

                if (curr.children[idx] == null) {
                    return false;
                }

                curr = curr.children[idx];
            }

            return curr.token != null;
        }
    }

    private static class Node {

        String token;
        Node[] children;

        public Node() {
            token = null;
            children = new Node[26];
        }
    }
}
