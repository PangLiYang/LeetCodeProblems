package array_string;

public class Easy_13 {
    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);

            if (i == s.length() - 1) {
                return ans + toInt(c);
            }

            if (c == 'C' && s.charAt(i + 1) == 'D') {
                ans += 400;
                i += 1;
                continue;
            }

            if (c == 'C' && s.charAt(i + 1) == 'M') {
                ans += 900;
                i += 1;
                continue;
            }

            if (c == 'X' && s.charAt(i + 1) == 'L') {
                ans += 40;
                i += 1;
                continue;
            }

            if (c == 'X' && s.charAt(i + 1) == 'C') {
                ans += 90;
                i += 1;
                continue;
            }

            if (c == 'I' && s.charAt(i + 1) == 'V') {
                ans += 4;
                i += 1;
                continue;
            }

            if (c == 'I' && s.charAt(i + 1) == 'X') {
                ans += 9;
                i += 1;
                continue;
            }

            ans += toInt(c);
        }

        return ans;

    }

    private static int toInt (char c) {
        if (c == 'M') {
            return 1000;
        }

        if (c == 'D') {
            return 500;
        }

        if (c == 'C') {
            return 100;
        }

        if (c == 'L') {
            return 50;
        }

        if (c =='X') {
            return 10;
        }

        if (c =='V') {
            return 5;
        }

        if (c =='I') {
            return 1;
        }

        return 0;
    }
}
