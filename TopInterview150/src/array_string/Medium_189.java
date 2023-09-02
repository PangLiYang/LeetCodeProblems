package array_string;

public class Medium_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int rot = k % n;
        reverse(nums, 0, n);
        reverse(nums, 0, rot);
        reverse(nums, rot, n);
    }

    private static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int tmp = arr[start];
            arr[start] = arr[end - 1];
            arr[end - 1] = tmp;
            start += 1;
            end -= 1;
        }
    }
}
