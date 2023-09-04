package array_string;

public class Easy_58 {
    public int lengthOfLastWord(String s) {

        int count = 0;

        for (int i =  s.length() - 1; i >= 0; i -= 1) {
            if (s.charAt(i) != ' ') {
                count += 1;
            } else if (count != 0) {
                return count;
            }
        }
        return count;
    }
}
