package stack;

import java.util.LinkedList;

public class Medium_155 {
    LinkedList<Integer> st;
    LinkedList<Integer> maxRec;
    int pos;

    public Medium_155() {
        st = new LinkedList<>();
        maxRec = new LinkedList<>();
        pos = 0;

    }

    public void push(int val) {
        if (pos == 0) {
            maxRec.add(val);
        } else {
            maxRec.add(Math.min(maxRec.getLast(), val));
        }

        st.add(val);
        pos += 1;
    }

    public void pop() {
        maxRec.removeLast();
        st.removeLast();
        pos -= 1;
    }

    public int top() {
        return st.getLast();
    }

    public int getMin() {
        return maxRec.getLast();
    }
}
