package array_string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hard_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> output = new LinkedList<>();

        int idx = 0;
        int n = words.length;
        StringBuilder sb = new StringBuilder();

        while (idx < n) {
            int group = words[idx].length();
            int offset = 1;

            while (idx + offset < n && group + words[idx + offset].length() + offset <= maxWidth) {
                group += words[idx + offset].length();
                offset += 1;
            }

            int space = maxWidth - group;

            if (offset != 1 && idx + offset != n) {
                int norm = space / (offset - 1);
                int sup = space % (offset - 1);
                int[] ems = new int[offset - 1];
                Arrays.fill(ems, norm);
                for (int i = 0; i < sup; i += 1) {
                    ems[i] += 1;
                }

                for (int i = 0; i < offset - 1; i += 1) {
                    sb.append(words[idx + i]);
                    sb.append(" ".repeat(ems[i]));
                }

                sb.append(words[idx + offset - 1]);

            } else {

                for (int i = 0; i < offset - 1; i += 1) {
                    sb.append(words[idx + i]);
                    sb.append(" ");
                }

                sb.append(words[idx + offset - 1]);

                int rep = maxWidth - sb.length();
                sb.append(" ".repeat(rep));
            }

            output.add(sb.toString());
            sb.setLength(0);

            idx += offset;
        }

        return output;
    }
}
