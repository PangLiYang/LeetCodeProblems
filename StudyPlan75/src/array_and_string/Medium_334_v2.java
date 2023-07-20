package array_and_string;

public class Medium_334_v2 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                big = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Medium_334_v2 test = new Medium_334_v2();
        int[] arr = new int[]{1, 2, 0, 1, 1, 3, 1, 1};

        System.out.println(test.increasingTriplet(arr));
    }
}
