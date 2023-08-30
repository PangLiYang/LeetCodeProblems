package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Medium_208 {

    private Node root;

    private class Node {
        boolean isKey;
        Map<Character, Node> map;

        public Node() {
            this.isKey = false;
            this.map = new HashMap<>();
        }
    }

    public Medium_208() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i +=1) {
            char target = word.charAt(i);

            if (!cur.map.containsKey(target)) {
                Node newNode = new Node();

                if (i == word.length() - 1) {
                    newNode.isKey = true;
                }

                cur.map.put(target, newNode);
                cur = newNode;
            } else {
                Node newNode = cur.map.get(target);
                if (i == word.length() - 1) {
                    newNode.isKey = true;
                }
                cur = newNode;
            }
        }
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i += 1) {
            char target = word.charAt(i);

            if (!cur.map.containsKey(target)) {
                return false;
            }

            cur = cur.map.get(target);

            if (i == word.length() - 1 && !cur.isKey) {
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i += 1) {
            char target = prefix.charAt(i);

            if (!cur.map.containsKey(target)) {
                return false;
            }

            cur = cur.map.get(target);
        }
        return true;
    }

    public List<String> showWords() {
        List<String> myList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        DfsHelper(myList, sb, root);
        return myList;
    }

    private void DfsHelper(List<String> list, StringBuilder sb, Node pos) {
        if (pos.isKey) {
            list.add(sb.toString());
        }
        if (pos.map.isEmpty()) {
            return;
        }
        for (var entry: pos.map.entrySet()) {
            sb.append(entry.getKey());
            DfsHelper(list, sb, entry.getValue());
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Medium_208 myTries = new Medium_208();
        myTries.insert("apple");
        myTries.insert("aps");
        System.out.println(myTries.search("appl"));
        System.out.println(myTries.startsWith("appl"));
//        List<String> ans = myTries.showWords();
//        for (String str: ans) {
//            System.out.println(str);
//        }
    }
}
