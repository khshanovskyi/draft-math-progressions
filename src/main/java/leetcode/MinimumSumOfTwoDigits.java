package leetcode;

import java.util.Arrays;

public class MinimumSumOfTwoDigits {

    public static void main(String[] args) {
        System.out.println(minimumSum(9232));
    }

    public static int minimumSum(int num) {
        char[] chars = ("" + num).toCharArray();
        Arrays.sort(chars);

        return Integer.parseInt("" + chars[0] + chars[2]) + Integer.parseInt("" + chars[1] + chars[3]);
    }

    private static void sort(char... arr) {
        char tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //if we know that there are always 4 digits:

    public static int minimumSum2(int num) {
        int[] ints = new int[4];

        for (int i = 0; i < 4; i++) {
            ints[i] = num % 10;
            num /= 10;
        }

        return (ints[0] * 10 + ints[3]) + (ints[2] * 10 + ints[3]);
    }


}
