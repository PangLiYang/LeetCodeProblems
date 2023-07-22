package stack;

import java.util.Arrays;
import java.util.Stack;

public class Medium_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i : asteroids) {
            pushAsteriods(st, i);
        }

        int[] result = new int[st.size()];
        int index = st.size() - 1;

        while (!st.isEmpty()) {
            result[index] = st.pop();
            index -= 1;
        }

        return result;
    }

    private void pushAsteriods(Stack<Integer> st, int ast) {
        if (st.isEmpty() || ast > 0) {
            st.push(ast);
            return;
        }

        if (st.peek() < 0) {
            st.push(ast);
        } else {
            if (Math.abs(ast) > Math.abs(st.peek())) {
                st.pop();
                pushAsteriods(st, ast);
            } else if (Math.abs(ast) == Math.abs(st.peek())) {
                st.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,1,2};
        Medium_735 tt = new Medium_735();
        System.out.println(Arrays.toString(tt.asteroidCollision(arr)));
    }
}
