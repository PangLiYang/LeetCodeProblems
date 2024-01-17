package stack;

public class Hard_224 {

    public int calculate(String s) {

        int[] idx = {0};
        char[] charOfS = s.toCharArray();

        return subCal(charOfS, idx);
    }

    private int subCal(char[] charOfS, int[] idx) {

        int sum = 0;
        int dir = 1;

        while (idx[0] < charOfS.length) {
            char c = charOfS[idx[0]];

            if (c == ' ') {
                idx[0] += 1;
            }

            if (c == ')') {
                idx[0] += 1;
                return sum;
            }

            if (c == '(') {
                idx[0] += 1;
                sum += dir * subCal(charOfS, idx);
            }

            if (c == '-') {
                idx[0] += 1;
                dir = -1;
            }

            if (c == '+') {
                idx[0] += 1;
                dir = 1;
            }

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (idx[0] + 1 < charOfS.length && Character.isDigit(charOfS[idx[0] + 1])) {
                    idx[0] += 1;
                    sb.append(charOfS[idx[0]]);
                }
                sum += dir * Integer.parseInt(sb.toString());
                idx[0] += 1;
            }
        }

        return sum;

    }
}
