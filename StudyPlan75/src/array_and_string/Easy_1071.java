package array_and_string;

public class Easy_1071 {

    public String gcdOfStrings(String str1, String str2) {
        String str = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str1.length(); i += 1) {
            sb.append(str1.charAt(i));
            if (isDiv(str1, sb.toString()) && isDiv(str2, sb.toString())) {
                str = sb.toString();
            }
        }

        return str;
    }

    private static boolean isDiv(String ori, String div) {
        StringBuilder sb = new StringBuilder();
        sb.append(ori);

        if ("".equals(ori)) {
            return true;
        }

        if (ori.startsWith(div)) {
            for (int i = 0; i < div.length(); i += 1) {
                sb.deleteCharAt(0);
            }
            return isDiv(sb.toString(), div);
        }

        return false;
    }
}
