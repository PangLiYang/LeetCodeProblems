import java.util.Arrays;

public class Test {
    public int maxArea(int[] heights) {
        int lp = 0;
        int rp = heights.length - 1;

        int maxHeight = 0;
        int vol = 0;

        while (lp < rp) {
            if (heights[lp] > maxHeight && heights[rp] > maxHeight) {
                maxHeight = Math.min(heights[lp], heights[rp]);
                vol = Math.max(vol, maxHeight * (rp - lp));
            }

            if (heights[lp] == maxHeight) {
                lp += 1;
            } else {
                rp += 1;
            }
        }

        return vol;
    }
}
