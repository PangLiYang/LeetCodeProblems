package two_pointer;

public class Medium_11 {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxHeight = 0;
        int maxArea = 0;

        while (left < right) {
            if (heights[left] > maxHeight && heights[right] > maxHeight) {
                maxHeight = Math.min(heights[left], heights[right]);
                maxArea = Math.max(maxArea, maxHeight * (right - left));
            }

            if (heights[left] < heights[right]) {
                left ++;
            } else {
                right --;
            }
        }

        return maxArea;
    }
}
