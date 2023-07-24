package queue;

import java.util.HashSet;
import java.util.LinkedList;

public class Medium_649 {
    public String predictPartyVictory(String senate) {
        LinkedList<Character> voteList = new LinkedList<>();

        for (char c : senate.toCharArray()) {
            voteList.addLast(c);
        }

        return collision(voteList);
    }

    private String collision(LinkedList<Character> voteList) {

        if (new HashSet<Character>(voteList).size() <= 1) {
            if (voteList.getFirst() == 'R') {
                return "Radiant";
            }
            return "Dire";
        }

        int rVote = 0;
        int dVote = 0;
        LinkedList<Character> newList = new LinkedList<>();

        for (char c : voteList) {
            if (c == 'R') {
                if (dVote > 0) {
                    dVote -= 1;
                } else {
                    newList.addLast(c);
                    rVote += 1;
                }
            } else {
                if (rVote > 0) {
                    rVote -= 1;
                } else {
                    newList.addLast(c);
                    dVote += 1;
                }
            }
        }

        while (rVote > 0) {
            newList.addFirst('R');
            newList.removeLast();
            rVote -= 1;
        }

        while (dVote > 0) {
            newList.addFirst('D');
            newList.removeLast();
            dVote -= 1;
        }

        return collision(newList);
    }
}
