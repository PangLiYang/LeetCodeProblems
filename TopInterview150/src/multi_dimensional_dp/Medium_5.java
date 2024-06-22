package multi_dimensional_dp;

public class Medium_5 {

    public String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        int max = 0;
        String[] out = new String[1];
        char[] strArray = s.toCharArray();

        for (int i = 0; i < strArray.length; i += 1) {

            max = single(strArray, i, max, out);

            if (i < strArray.length - 1 && strArray[i] == strArray[i + 1]) {
                max = dul(strArray, i, max, out);
            }
        }

        return out[0];

    }

    private int single (char[] strArray, int idx, int max, String[] out) {

        int l = idx;
        int r = idx;
        int curr = 1;

        while (l - 1 >= 0 && r + 1 < strArray.length && strArray[l - 1] == strArray[r + 1]) {
            curr += 2;
            l -= 1;
            r += 1;
        }

        if (curr > max) {
            StringBuilder sb = new StringBuilder();
            for (int i = r; i >= l; i -= 1) {
                sb.append(strArray[i]);
            }
            out[0] = sb.toString();
            return curr;
        }

        return max;
    }

    private int dul (char[] strArray, int idx, int max, String[] out) {

        int l = idx;
        int r = idx + 1;
        int curr = 2;

        while (l - 1 >= 0 && r + 1 < strArray.length && strArray[l - 1] == strArray[r + 1]) {
            curr += 2;
            l -= 1;
            r += 1;
        }

        if (curr > max) {
            StringBuilder sb = new StringBuilder();
            for (int i = r; i >= l; i -= 1) {
                sb.append(strArray[i]);
            }
            out[0] = sb.toString();
            return curr;
        }

        return max;
    }
}
