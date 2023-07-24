package queue;

import java.util.HashSet;
import java.util.LinkedList;

public class Medium_649_2 {
    public String predictPartyVictory(String senate) {
        LinkedList<Character> voteList = new LinkedList<>();

        for (char c : senate.toCharArray()) {
            voteList.addLast(c);
        }

        return collision(voteList);
    }

    private String collision(LinkedList<Character> voteList) {
        LinkedList<Integer> rList = new LinkedList<>();
        LinkedList<Integer> dList = new LinkedList<>();
        LinkedList<Character> newList = new LinkedList<>();
        int r;
        int d;
        int size = voteList.size();

        for (int i = 0; i < size; i += 1) {
            if (voteList.getFirst() == 'R') {
                rList.addLast(i);
                voteList.removeFirst();
            } else {
                dList.addLast(i);
                voteList.removeFirst();
            }
        }

        if (rList.isEmpty()) {
            return "Dire";
        }

        if (dList.isEmpty()) {
            return "Radiant";
        }

        while (!rList.isEmpty() && !dList.isEmpty()) {
            r = rList.removeFirst();
            d = dList.removeFirst();
            if (r < d) {
                newList.addLast('R');
            } else {
                newList.addLast('D');
            }
        }

        while (!rList.isEmpty()) {
            newList.addFirst('R');
            rList.removeFirst();
        }

        while (!dList.isEmpty()) {
            newList.addFirst('D');
            dList.removeFirst();
        }

        return collision(newList);
    }
}
