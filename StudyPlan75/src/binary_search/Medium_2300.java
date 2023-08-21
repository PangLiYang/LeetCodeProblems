package binary_search;

import java.util.Arrays;

public class Medium_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[] pairs = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < n; i += 1) {
            int spell = spells[i];
            int minPotion = (int) Math.ceil((1.0 * success) / spell);
            int lb = 0;
            int ub = m - 1;
            int target;

            if (potions[ub] < minPotion) {
                pairs[i] = 0;
                continue;
            } else if (potions[lb] >= minPotion) {
                pairs[i] = m;
                continue;
            }

            while (lb <= ub) {
                target = lb + (ub - lb) / 2;
                if (potions[target] >= minPotion && potions[target - 1] < minPotion) {
                    pairs[i] = m - target;
                    break;
                } else if (potions[target] < minPotion) {
                    lb = target + 1;
                } else if (potions[target - 1] >= minPotion) {
                    ub = target - 1;
                }
            }
        }

        return pairs;
    }
}
