package linked_list;

import java.util.HashMap;
import java.util.Map;

class Medium_146 {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public Medium_146(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node curr = map.get(key);

        if (curr == null) {
            return -1;
        }

        remove(curr);
        add(curr);

        return curr.value;
    }

    public void put(int key, int value) {
        Node curr = map.get(key);
        if (curr == null) {
            curr = new Node (key, value);
            map.put(key, curr);
            add(curr);
            size += 1;
        } else {
            curr.value = value;
            remove(curr);
            add(curr);
        }

        if (size > capacity) {
            Node del = tail.prev;
            remove(del);
            map.remove(del.key);
            size -= 1;
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node) {
        Node start = head.next;
        head.next = node;
        node.prev = head;
        node.next = start;
        start.prev = node;
    }
}
