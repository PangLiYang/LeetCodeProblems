package array_and_string;

public class Easy_1071_v2 {

    public String gcdOfStrings(String str1, String str2) {
        String str = "";
        int l1 = str1.length();
        int l2 = str2.length();

        for (int i = Math.min(l1, l2); i > 0; i -= 1) {
            if (isDiv(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }

        return str;
    }

    private static boolean isDiv(String str1, String str2, int k) {
        if (str1.length() % k != 0 || str2.length() % k != 0) {
            return false;
        }

        String base = str1.substring(0, k);
        return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
    }
}
