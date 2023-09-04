package array_string;

public class Medium_12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int div = 1000;
        int k = 2;
        char c = 'M';

        while (num >= 5) {
            int count = num / div;
            num = num % div;

            switch (div) {
                case 1000: c = 'M'; break;
                case 500: c = 'D'; break;
                case 100: c = 'C'; break;
                case 50: c = 'L'; break;
                case 10: c = 'X'; break;
                case 5: c = 'V'; break;
            }

            for (int i = 0; i < count; i += 1) {
                sb.append(c);
            }

            if (k == 2) {
                div = div / 2;
                k = 5;
            } else {
                div = div / 5;
                k = 2;
            }
        }

        for (int i = 0; i < num; i += 1) {
            sb.append('I');
        }

        String ans = sb.toString()
                .replace("DCCCC", "CM")
                .replace("CCCC", "CD")
                .replace("LXXXX", "XC")
                .replace("XXXX", "XL")
                .replace("VIIII", "IX")
                .replace("IIII", "IV");

        return ans;
    }
}
