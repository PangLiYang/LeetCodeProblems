package trie;

import java.util.*;

public class Medium_1268 {

    private Node root = new Node();

    private static class Node {
        boolean isKey;
        Map<Character, Node> map;

        public Node() {
            this.isKey = false;
            this.map = new TreeMap<>();
        }
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

    public List<String> showWords(String str) {
        List<String> myList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Node cur = root;

        for (int i = 0; i < str.length(); i += 1) {
            char target = str.charAt(i);
            if (!cur.map.containsKey(target)) {
                return myList;
            }

            sb.append(target);
            cur = cur.map.get(target);
        }

        DfsHelper(myList, sb, cur);
        return myList;
    }

    private static void DfsHelper(List<String> list, StringBuilder sb, Node pos) {
        if (pos.isKey) {
            if (list.size() >= 3) {
                return;
            }
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

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        for (String str: products) {
            insert(str);
        }

        for (int i = 1; i <= searchWord.length(); i += 1) {
            String partSearch = searchWord.substring(0, i);
            result.add(showWords(partSearch));
        }
        return result;
    }
}
