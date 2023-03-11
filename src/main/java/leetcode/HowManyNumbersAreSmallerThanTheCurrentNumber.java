package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public static void main(String[] args) {
        int[] arr = {8, 1, 2, 2, 3};
        int[] ints = smallerNumbersThanCurrent3(arr);
        Arrays.stream(ints).forEach(i -> System.out.print(i + ", "));
    }

    /*
        Input: nums = [8,1,2,2,3]
        Output: [4,0,1,1,3]
        Explanation:
        For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
        For nums[1]=1 does not exist any smaller number than it.
        For nums[2]=2 there exist one smaller number than it (1).
        For nums[3]=2 there exist one smaller number than it (1).
        For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] sorted = sort(nums);
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[i] == sorted[j]) {
                    res[i] = j;
                    break;
                }
            }
        }

        return res;
    }

    private static int[] sort(int... arr) {
        int length = arr.length;
        int[] ints = new int[length];
        System.arraycopy(arr, 0, ints, 0, length);
        int tmp;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (ints[j - 1] > ints[j]) {
                    tmp = ints[j - 1];
                    ints[j - 1] = ints[j];
                    ints[j] = tmp;
                }
            }
        }

        return ints;
    }

    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int counter = 0;
            for (int i : nums) {
                if (num > i) {
                    counter++;
                }
            }
            map.put(num, counter);
        }

        for (int i = 0; i < length; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }

    public static int[] smallerNumbersThanCurrent3(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            int counter = 0;
            for (int num : nums) {
                if (nums[i] > num) {
                    counter++;
                }
            }
            res[i] = counter;
        }

        return res;
    }
}
