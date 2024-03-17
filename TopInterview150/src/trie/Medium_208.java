package trie;

public class Medium_208 {

    Node root;

    public Medium_208() {
        root = new Node();
    }

    public void insert(String word) {

        char[] charArr = word.toCharArray();
        Node curr = root;

        for (int i = 0; i < charArr.length; i += 1) {

            int idx = charArr[i] - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];

            if (i == charArr.length - 1) {
                curr.isToken = true;
            }
        }
    }

    public boolean search(String word) {

        Node curr = toSearchPoint(word);

        if (curr == null) {
            return false;
        }
        return curr.isToken;
    }

    public boolean startsWith(String prefix) {

        Node curr = toSearchPoint(prefix);

        return curr != null;
    }

    private Node toSearchPoint(String word) {

        char[] charArr = word.toCharArray();
        Node curr = root;

        for (char c : charArr) {

            int idx = c - 'a';

            if (curr.children[idx] == null) {
                return null;
            }

            curr = curr.children[idx];
        }

        return curr;
    }

    private static class Node {

        public boolean isToken;
        public Node[] children;

        public Node() {

            isToken = false;
            children = new Node[26];

        }
    }
}