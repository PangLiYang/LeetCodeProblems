package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class Medium_334 {
    public boolean increasingTriplet(int[] nums) {
        int curr;
        int pivot = 0;
        int pivotIndex = 0;
        boolean start;

        if (!checkMoreThanThree(nums)) {
            return false;
        }


        for (int i = 0; i < nums.length - 2; i += 1) {
            curr = nums[i];
            start = false;

            for (int j = i + 1; j < nums.length - 1; j += 1) {
                if (nums[j] > curr) {
                    pivot = nums[j];
                    pivotIndex = j;
                    start = true;
                    break;
                }
            }

            if (start) {
                for (int j = pivotIndex + 1; j < nums.length; j += 1) {
                    if (nums[j] < pivot && nums[j] > curr) {
                        pivot = nums[j];
                    } else if (nums[j] > pivot) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean checkMoreThanThree(int[] arr) {
        Set<Integer> checkSet = new HashSet<>();

        if (arr.length < 3) {
            return false;
        }

        for (int i: arr) {
            checkSet.add(i);
        }

        if (checkSet.size() >= 3) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Medium_334 test = new Medium_334();
        int[] arr = new int[]{0,4,2,1,0,-1,-3};

        System.out.println(test.increasingTriplet(arr));
    }
}
