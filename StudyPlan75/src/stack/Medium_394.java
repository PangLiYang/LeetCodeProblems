package stack;

import java.util.Stack;

public class Medium_394 {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                st.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && Character.isLetter(st.peek())) {
                    sb.append(st.pop());
                }
                sb.reverse();
                String subString = sb.toString();
                st.pop();

                sb = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    sb.append(st.pop());
                }
                sb.reverse();
                int repeat = Integer.valueOf(sb.toString());

                while (repeat > 0) {
                    for (char subC : subString.toCharArray()) {
                        st.push(subC);
                    }
                    repeat -= 1;
                }
            }
        }

        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        result.reverse();

        return result.toString();
    }
}
