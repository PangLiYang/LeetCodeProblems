package graph_bfs;

import java.util.*;

public class Hard_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordTokens = new HashSet<>(wordList);

        if (!wordTokens.contains(endWord)) {
            return 0;
        }

        Set<String> from = new HashSet<>();
        Set<String> to = new HashSet<>();
        Set<String> vis = new HashSet<>();

        from.add(beginWord);
        to.add(endWord);
        int steps = 2;

        while (!from.isEmpty()) {
            Set<String> temp = new HashSet<>();

            for (String curr : from) {
                for (int j = 0; j < curr.length(); j += 1) {
                    char[] currChar = curr.toCharArray();

                    for (char c = 'a'; c <= 'z'; c += 1) {
                        if (c == currChar[j]) {
                            continue;
                        }

                        currChar[j] = c;

                        String next = String.valueOf(currChar);

                        if (to.contains(next)) {
                            return steps;
                        }

                        if (wordTokens.contains(next) && !vis.contains(next)) {
                            vis.add(next);
                            temp.add(next);
                        }
                    }
                }
            }

            from = (temp.size() < to.size())? temp : to;
            to = (from == temp)? to : temp;
            steps += 1;
        }

        return 0;
    }
}
