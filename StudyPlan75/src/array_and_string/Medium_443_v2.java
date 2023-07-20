package array_and_string;

public class Medium_443_v2 {
    public int compress(char[] chars) {
        int index = 0;
        int count;

        for (int i = 0; i < chars.length; i += 1) {
            char c = chars[i];
            chars[index] = c;
            index += 1;

            count = 1;
            for (int j = i + 1; j < chars.length; j += 1) {
                if (chars[j] != c) {
                    break;
                }
                count += 1;
            }
            i += count -1;

            if (count > 1) {
                for (char n: Integer.toString(count).toCharArray()) {
                    chars[index] = n;
                    index += 1;
                }
            }
        }

        return index;
    }
}
