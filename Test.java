import java.util.*;

public class Test {

    public static void quickSort(int[] arr, int lp, int rp) {
        if (lp >= rp) {
            return;
        }

        int[] sub = threeWay(arr, lp, rp);
        quickSort(arr, lp, sub[0]);
        quickSort(arr, sub[1], rp);
    }

    private static int[] threeWay(int[] arr, int lp, int rp) {

        int[] out = new int[2];
        int pivot = arr[rp];
        int pos = lp;

        while (pos <= rp) {
            if (arr[pos] < pivot) {
                swap(arr, pos, lp);
                lp += 1;
                pos += 1;
            } else if (arr[pos] > pivot) {
                swap(arr, pos, rp);
                rp -= 1;
            } else {
                pos += 1;
            }
        }

        out[0] = lp - 1;
        out[1] = rp + 1;

        return out;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {17, 15, 19, 32, 2, 26, 41, 17, 17};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {173, 395, 173, 0, -50, 15, 19, 32, 2, 26, 41, 17, 173};
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {-1, -2, -3, -4, -5};
        quickSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));
    }
}
