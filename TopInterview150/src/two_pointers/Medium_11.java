package two_pointers;

public class Medium_11 {
    public int maxArea(int[] heights) {
        int lp = 0;
        int rp = heights.length - 1;
        int curr = 0;
        int maxVol = 0;

        while (lp < rp) {
            if (heights[lp] > curr && heights[rp] > curr) {
                curr = Math.min(heights[lp], heights[rp]);
                maxVol = Math.max(maxVol, curr * (rp - lp));
            }
            if (heights[lp] <= curr) {
                lp += 1;
            } else {
                rp -= 1;
            }
        }

        return maxVol;
    }
}
