package stack;

import java.util.Stack;

public class Easy_20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (hasPair(st, c)) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        return st.isEmpty();

    }

    private static boolean hasPair(Stack<Character> st, char c) {
        if (st.isEmpty()) {
            return false;
        }
        if (c == ')' && st.peek() == '(') {
            return true;
        }
        if (c == ']' && st.peek() == '[') {
            return true;
        }
        if (c == '}' && st.peek() == '{') {
            return true;
        }
        return false;
    }
}
