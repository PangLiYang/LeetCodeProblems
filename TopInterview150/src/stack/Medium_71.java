package stack;

import java.util.Arrays;
import java.util.Stack;

public class Medium_71 {
    public String simplifyPath(String path) {
        String[] comps = path.split("/");
        Stack<String> st = new Stack<>();

        System.out.println(Arrays.toString(comps));

        for (String str: comps) {
            if (str.equals("") || str.equals("/") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.insert(0,st.pop());
            sb.insert(0,"/");
        }

        if (sb.isEmpty()) {
            sb.append("/");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "/../";
        Medium_71 tt = new Medium_71();
        System.out.println(tt.simplifyPath(input));
    }
}
