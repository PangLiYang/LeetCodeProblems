package hash_map;

public class Easy_242 {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        for (char c: s.toCharArray()) {
            arr[c - 'a'] += 1;
        }

        for (char c: t.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                return false;
            }
            arr[c - 'a'] -= 1;
        }

        for (int i: arr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
