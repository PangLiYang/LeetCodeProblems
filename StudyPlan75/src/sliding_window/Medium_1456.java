package sliding_window;

public class Medium_1456 {
    public int maxVowels(String s, int k) {
        char[] cArr = s.toCharArray();
        int sum = 0;

        for (int i = 0; i < k; i += 1) {
            sum += isVowel(cArr[i]);
        }

        int max = sum;

        for (int i = k; i < cArr.length; i += 1) {
            sum += isVowel(cArr[i]);
            sum -= isVowel(cArr[i - k]);
            max = Math.max(max, sum);
        }

        return max;
    }

    private int isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return 1;
        }
        return 0;
    }
}
