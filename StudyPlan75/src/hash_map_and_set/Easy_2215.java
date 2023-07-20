package hash_map_and_set;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Easy_2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        for (int i: nums1) {
            set1.add(i);
        }

        for (int i: nums2) {
            set2.add(i);
        }

        for (int i: set1) {
            if (!set2.contains(i)) {
                list1.add(i);
            }
        }

        for (int i: set2) {
            if (!set1.contains(i)) {
                list2.add(i);
            }
        }

        result.add(list1);
        result.add(list2);

        return result;
    }
}
