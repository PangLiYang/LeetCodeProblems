package array_and_string;

import java.util.ArrayList;
import java.util.List;

public class Easy_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = 0;

        for (int candy: candies) {
            if (candy > max) {
                max = candy;
            }
        }

        for (int i = 0; i < candies.length; i += 1) {
            list.add(candies[i] + extraCandies >= max);
        }

        return list;
    }
}
