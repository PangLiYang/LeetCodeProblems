import java.util.*;

public class Test {

    public static void main(String[] args) {

        Set<List<Integer>> set = new HashSet<>();

        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);

        List<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(2);

        set.add(l1);

        if(set.contains(l2)) {
            System.out.println("true!");
        }

    }
}
