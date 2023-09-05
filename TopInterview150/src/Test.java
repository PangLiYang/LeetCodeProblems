import java.util.*;

public class Test {

    public int[] mergeSort (int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return arr;
        }

        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, n / 2));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, n / 2, n));
        int[] ans = new int[n];
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < n / 2 && j < n - n / 2){
            if (arr1[i] <= arr2[j]) {
                ans[idx] = arr1[i];
                i += 1;
            } else {
                ans[idx] = arr2[j];
                j += 1;
            }
            idx += 1;
        }

        while(i < n / 2) {
            ans[idx] = arr1[i];
            i += 1;
            idx += 1;
        }

        while(j < n - n / 2) {
            ans[idx] = arr2[j];
            j += 1;
            idx += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] input = {-2, -1, 1, 2, 5, 9, 1, 2, 5, -5};
        Test tt = new Test();
        System.out.println(Arrays.toString(tt.mergeSort(input)));
    }
}
