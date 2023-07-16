package arrayandstring;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class easy_345 {
    public String reverseVowels(String s) {
        Set<Character> set = new TreeSet<>();
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        for (int i = 0; i < s.length(); i += 1) {
            if (set.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            }
        }

        for (int i = 0; i < s.length(); i += 1) {
            if (set.contains(s.charAt(i))) {
                sb.replace(i, i + 1, list.remove(list.size() - 1).toString());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        easy_345 test = new easy_345();
        System.out.println(test.reverseVowels("apple"));
    }
}
