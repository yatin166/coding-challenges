package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindIntersection {

    private static int[] intersection(int[] nums1, int[] nums2) {
        /*Set<Integer> set = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int num: nums2) {
            if (set.contains(num) && (list.size() == 0 || list.get(0) != num)) {
                list.add(num);
            }
            if (list.size() == 2) {
                break;
            }
        }

        return list.stream().mapToInt(i -> i).toArray();*/

        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }

        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
