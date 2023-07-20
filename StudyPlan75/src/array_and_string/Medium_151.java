package array_and_string;

public class Medium_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for (String str: s.split(" ")) {
            if (!"".equals(str)) {
                sb.insert(0, str);
                sb.insert(0, " ");
            }
        }

        sb.deleteCharAt(0);
        return sb.toString();
    }
}
