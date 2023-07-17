package arrayandstring;

public class medium_443 {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count;

        for (int i = 0; i < chars.length; i += 1) {
            char c = chars[i];
            count = 1;
            for (int j = i + 1; j < chars.length; j += 1) {
                if (chars[j] != c) {
                    break;
                }
                count += 1;
            }
            i += count -1;

            sb.append(c);
            if (count > 1) {
                sb.append(count);
            }
        }

        for (int i = 0; i < sb.toString().length(); i += 1) {
            chars[i] = sb.charAt(i);
        }

        return sb.toString().length();
    }
}
