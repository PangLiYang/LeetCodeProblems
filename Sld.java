import java.util.*;

public class Sld {

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
