import java.util.*;

public class Test {

    public static int[] mss(int[] arr) {
        int l = 0;
        int m = arr.length - 1;

        if (m - l + 1 < 3) {
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        }

        if (m - l + 1 < 5 ) {
            return msc(arr);
        }

        int[] left = mss(Arrays.copyOfRange(arr, 0, (l + m) / 2 + 1));
        int[] right = mss(Arrays.copyOfRange(arr, (l + m) / 2 + 1, m + 1));
        int[] all = msc(arr);

        int v1 = left[1] - left[0];
        int v2 = right[1] - right[0];
        int v3 = all[1] - all[0];

        if (v1 <= v2 && v1 <= v3) {
            return left;
        }

        if (v2 < v1 && v2 <= v3) {
            return right;
        }

        return all;
    }

    public static int[] msc(int[] arr) {
        int l = 0;
        int m = arr.length - 1;

        int i = (l + m) / 2;
        int j = (l + m) / 2 + 1;

        if (arr[i] == arr[j]) {
            int b = arr[i];

            while (arr[i] == b && i > l) {
                i -= 1;
            }

            while (arr[j] == b && j < m) {
                j += 1;
            }

            if (arr[i] != arr[j]) {
                return new int[]{i, j};
            } else {
                return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            }
        } else {
            int b = arr[i];
            int c = arr[j];

            while (arr[i] == b && i > l) {
                i -= 1;
            }

            if (arr[i] != c) {
                return new int[]{i, j};
            }

            int a = b;
            b = arr[j];

            while (arr[j] == b && j < m) {
                j += 1;
            }

            if (arr[j] != a) {
                return new int[]{(l + m) / 2, j};
            }
        }

        return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
    }

    public static int[] sld(int[] arr) {
        if (arr.length < 3) {
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        }

        int min = Integer.MAX_VALUE;
        int[] res = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int i = 0;
        int j = 1;

        while (j < arr.length - 1) {

            while (arr[i] == arr[j] && j < arr.length - 2) {
                i += 1;
                j += 1;
            }

            int a = arr[i];
            int b = arr[j];
            int temp = j;

            j += 1;

            while ((arr[j] == a || arr[j] == b)  && j < arr.length - 2) {
                temp = j;
                j += 1;
            }

            int c = arr[j];

            if (a != b && a != c && b != c && j - i + 2 < min) {
                min = j - i + 2;
                res[0] = i;
                res[1] = j;
            }


            i = temp;
            j = i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {0,0,1,1,0,1,0,1,2};
        System.out.println(Arrays.toString(sld(input)));
    }
}
