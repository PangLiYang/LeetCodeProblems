package two_pointers;

import java.util.Arrays;

public class Medium_167 {
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0;
        int rp = numbers.length - 1;

        while (lp < rp) {
            int sum = numbers[lp] + numbers[rp];
            if (sum > target) {
                rp -= 1;
            } else if (sum < target) {
                lp += 1;
            } else {
                break;
            }
        }

        return new int[]{lp + 1, rp + 1};
    }
}
