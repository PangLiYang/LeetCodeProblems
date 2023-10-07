import java.util.*;

public class Test {

    public static int[] countingSort(int[] arr, int size) {
        int[] out = new int[arr.length];

        int[] count = new int[size + 1];

        for (int i : arr) {
            count[i] += 1;
        }

        int idx = 0;

        for (int i = 0; i < count.length; i += 1) {
            while (count[i] != 0) {
                out[idx] = i;
                count[i] -= 1;
                idx += 1;
            }
        }

        return out;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 3, 2, 2, 3, 1, 4};
        System.out.println(Arrays.toString(countingSort(arr, 4)));
    }
}
