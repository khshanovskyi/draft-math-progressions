package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 9, 3, 1, 9, 7, 6, 9, 7}, nums2 = {5, 0, 8};
        Arrays.stream(intersection2(nums1, nums2)).forEach(System.out::println);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> unique1 = new HashSet<>(), unique2 = new HashSet<>();
        for (int k : nums1) {
            unique1.add(k);
        }
        for (int k : nums2) {
            unique2.add(k);
        }

        return unique1.stream()
                .filter(unique2::contains)
                .mapToInt(i -> i)
                .toArray();
    }

    //wrong solution
    public static int[] intersection2(int[] nums1, int[] nums2) {
        StringBuilder builder = new StringBuilder();

        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i && !builder.toString().contains("" + k)) {
                    builder.append(k);
                    break;
                }
            }
        }
        String s = builder.toString();

        return s.length() == 0 ?
                new int[0] :
                Arrays.stream(s.split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();
    }


}
