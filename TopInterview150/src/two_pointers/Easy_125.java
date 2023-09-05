package two_pointers;

public class Easy_125 {
    public boolean isPalindrome(String s) {
        String sl = s.toLowerCase();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < sl.length(); i += 1) {
            char c = sl.charAt(i);
            if (c <= 'z' && c >= 'a') {
                sb1.append(c);
            } else if (c <= '9' && c >= '0') {
                sb1.append(c);
            }
        }

        for (int i = sl.length() - 1; i >= 0; i -= 1) {
            char c = sl.charAt(i);
            if (c <= 'z' && c >= 'a') {
                sb2.append(c);
            } else if (c <= '9' && c >= '0') {
                sb2.append(c);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        String input = "0P";
        Easy_125 tt = new Easy_125();
        System.out.println(tt.isPalindrome(input));
    }
}
