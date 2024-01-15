package array_string;

import java.util.Arrays;

public class Hard_42 {

    public int trap(int[] height) {

        int n = height.length;

        if (n == 1 || n == 2) {
            return 0;
        }

        int lp = 0;
        int output = 0;

        while (lp < n) {
            int move = 1;
            int trap = 0;

            while (lp + move < n && height[lp] > height[lp + move]) {
                trap += height[lp] - height[lp + move];
                move += 1;
            }

            lp += move;

            if (lp != n) {
                output += trap;
            } else {
                height = Arrays.copyOfRange(height, lp - move, n);
                reverse(height);
                output += trap(height);
            }
        }

        return output;
    }

    private void reverse(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i += 1) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
}
