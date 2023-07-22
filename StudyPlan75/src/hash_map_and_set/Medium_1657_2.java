package hash_map_and_set;

import java.util.Arrays;

public class Medium_1657_2 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int N = 26;

        int[] freqArr1 = new int[N];
        int[] freqArr2 = new int[N];

        for (char c : word1.toCharArray()) {
            freqArr1[c - 'a'] += 1;
        }

        for (char c : word2.toCharArray()) {
            freqArr2[c - 'a'] += 1;
        }

        for (int i = 0; i < N; i += 1) {
            if (freqArr1[i] == freqArr2[i]) {
                continue;
            }
            if (freqArr1[i] == 0 || freqArr2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(freqArr1);
        Arrays.sort(freqArr2);

        return Arrays.equals(freqArr1, freqArr2);
    }
}
