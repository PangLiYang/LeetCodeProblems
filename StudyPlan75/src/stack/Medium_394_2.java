package stack;

import java.util.Stack;

public class Medium_394_2 {
    private int i = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String tempString = "";

        while (i < s.length()) {
            char c = s.charAt(i);
            i += 1;

            if (c == '[') {
                tempString = decodeString(s);
                sb.append(tempString.repeat(Math.max(0, count)));
                count = 0;
            } else if (c == ']') {
                break;
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else {
                count = count * 10 + c - '0';
            }
        }

        return sb.toString();
    }
}
