package hash_map;

import java.util.HashSet;
import java.util.Set;

public class Easy_202 {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {

        if (n == 1) {
            return true;
        }

        if (set.contains(n)) {
            return false;
        }

        set.add(n);
        int sum = 0;

        while (n > 0) {
            int c = n % 10;
            sum += c * c;
            n /= 10;
        }

        return isHappy(sum);
    }
}
