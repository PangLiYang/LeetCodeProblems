package queue;

import java.util.LinkedList;

public class Easy_933 {
    LinkedList<Integer> pingList;

    public Easy_933() {
        pingList = new LinkedList<>();
    }

    public int ping(int t) {
        int count = 0;
        pingList.addLast(t);

        while (pingList.getFirst() < t - 3000) {
            pingList.removeFirst();
        }

        return pingList.size();
    }
}
