package org.example;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        reverse(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void reverse(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }

    //c++
    public static void main1(String[] args) {
        int[] arr ={};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //dosmth
        }
    }
}
