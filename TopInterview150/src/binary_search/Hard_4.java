package binary_search;

public class Hard_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n2 < n1) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;
        int left = (n + 1) / 2;
        int start = 0;
        int end = n1;

        while (start <= end) {

            int mid1 = start + (end - start) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = l1, r1 = Integer.MAX_VALUE, r2 = r1;

            if (mid1 < n1) {
                r1 = nums1[mid1];
            }

            if (mid2 < n2) {
                r2 = nums2[mid2];
            }

            if (mid1 > 0) {
                l1 = nums1[mid1 - 1];
            }

            if (mid2 > 0) {
                l2 = nums2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {

                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }

        return -1;
    }
}
