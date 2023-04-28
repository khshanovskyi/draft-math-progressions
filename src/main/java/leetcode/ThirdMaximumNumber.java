package leetcode;

import java.util.Arrays;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(thirdMax2(new int[]{1, 2, 2, 5, 3, 5}));
        System.out.println(thirdMax2(new int[]{1, -2147483648, 2}));
    }

    public static int thirdMax2(int[] nums) {
        Integer fdm = null, sdm = null, tdm = null;

        for (Integer i : nums) {
//            if ()
        }

        return fdm;
    }

    public static int thirdMax(int[] nums) {
        sort(nums, 0, nums.length - 1);

        int fdm = nums[0];
        Integer sdm = null;
        for (int i : nums) {
            if (i != fdm && sdm == null) {
                sdm = i;
            } else if (sdm != null && sdm != i) {
                return i;
            }
        }

        if (sdm == null) return fdm;

        return fdm > sdm ? fdm : sdm;
    }

    private static void sort(int[] arr, int p, int q) {
        if (p >= q) return;

        int i = partition(arr, p, q);

        sort(arr, p, i - 1);
        sort(arr, i + 1, q);
    }

    private static int partition(int[] arr, int p, int q) {
        int x = arr[q], i = p - 1, tmp;

        for (int j = p; j < q; j++) {
            if (arr[j] >= x) {
                tmp = arr[j];
                arr[j] = arr[++i];
                arr[i] = tmp;
            }
        }

        tmp = arr[i + 1];
        arr[i + 1] = arr[q];
        arr[q] = tmp;

        return i + 1;
    }
}
