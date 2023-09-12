package stack;

import java.util.Stack;

public class Medium_150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> st = new Stack<>();

        for (String s: tokens) {
            if (isOperator(s)) {
                int y = st.pop();
                int x = st.pop();
                st.push(cal(s, x, y));
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/");
    }

    private static int cal(String s, int x, int y) {
        if (s.equals("+")) {
            return x + y;
        }
        if (s.equals("-")) {
            return x - y;
        }
        if (s.equals("*")) {
            return x * y;
        }
        return x / y;
    }
}
