import java.util.*;

public class Test {
    public static void inSort(int[] arr, int n) {
        int idx = n - 1;

        if (n == 1) {
            return;
        }
        inSort(arr, n - 1);

        int temp = arr[idx];
        int pos = idx - 1;

        while (pos >= 0 && arr[pos] > temp) {
            arr[pos + 1] = arr[pos];
            pos -= 1;
        }

        arr[pos + 1] = temp;
    }

    public static void main(String[] args) {
        int[] input = {5, 4, 3, 2, 1};
        inSort(input, input.length);
        System.out.println(Arrays.toString(input));
    }

}
