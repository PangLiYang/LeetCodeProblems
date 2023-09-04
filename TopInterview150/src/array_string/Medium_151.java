package array_string;

public class Medium_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (String word: words) {
            if (!word.equals("")) {
                sb.insert(0, " " + word);
            }
        }
        sb.deleteCharAt(0);

        return sb.toString();
    }
}
