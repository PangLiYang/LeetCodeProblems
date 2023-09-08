package hash_map;

public class Easy_383_2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cArray = new int[26];

        for (char c: magazine.toCharArray()) {
            cArray[c - 'a'] += 1;
        }

        for (char c: ransomNote.toCharArray()) {
            if (cArray[c - 'a'] == 0) {
                return false;
            }

            cArray[c - 'a'] -= 1;
        }
        return true;
    }
}
