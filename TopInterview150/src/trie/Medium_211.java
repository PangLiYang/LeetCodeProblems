package trie;

public class Medium_211 {

    private final Node root;

    public Medium_211() {

        root = new Node();

    }

    public void addWord(String word) {

        Node curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {

        return searchHelper(word, root);

    }

    private boolean searchHelper(String subWord, Node node) {

        Node curr = node;

        for (int i = 0; i < subWord.length(); i += 1) {
            char c = subWord.charAt(i);

            if (c == '.') {

                String subString = subWord.substring(i + 1);

                for (Node next : curr.children) {
                    if (next != null && searchHelper(subString, next)) {
                        return true;
                    }
                }

                return false;
            } else {

                int idx = c - 'a';

                if (curr.children[idx] == null) {
                    return false;
                }

                curr = curr.children[idx];
            }
        }

        return curr.isEnd;
    }

    private static class Node {
        public boolean isEnd;
        public Node[] children;

        public Node() {
            isEnd = false;
            children = new Node[26];
        }
    }
}
