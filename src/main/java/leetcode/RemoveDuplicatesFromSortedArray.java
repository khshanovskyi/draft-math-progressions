package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3, 4};

        System.out.println(removeDuplicates(arr));
        System.out.println();

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;

        int q = 0;
        for (int i = 0; i < length; i++) {
            if (nums[q] < nums[i]) {
                nums[++q] = nums[i];
            }
        }

        return q + 1;
    }

}
