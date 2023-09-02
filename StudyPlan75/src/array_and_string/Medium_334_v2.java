package array_and_string;

public class Medium_334_v2 {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char target = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i += 1) {
            char c = chars[i];

            if (c != target) {
                sb.append(target);
                if (count != 1) {
                    sb.append(String.valueOf(count));
                }
                target = c;
                count = 1;
            } else {
                count += 1;
            }

            if (i == chars.length - 1) {
                sb.append(target);
                if (count != 1) {
                    sb.append(count);
                }
            }
        }

        return sb.length();
    }

    public static void main(String[] args) {
        Medium_334_v2 test = new Medium_334_v2();
        char[] arr = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        System.out.println(test.compress(arr));
    }
}
