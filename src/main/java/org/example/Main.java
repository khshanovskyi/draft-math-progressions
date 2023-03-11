package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Arithmetic progression is: " + sumOfArithmeticProgression(12, 18, 35, 28, 21));
    }

    private static int sumOfArithmeticProgression(int from, int to, int... nums) {
        int d = defineArithmeticProgression(nums);

        int f = nums[0] + d * (from - 1);
        int t = nums[0] + d * (to - 1);

        return ((f + t) * (to - from + 1)) / 2;
    }

    private static int defineArithmeticProgression(int... nums) {
        if (nums != null && nums.length > 1) {
            int d = nums[1] - nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] != d) {
                    throw new IllegalStateException("Provided [nums] doesn't have arithmetic progression...");
                }
            }
            return d;
        }
        throw new IllegalArgumentException("Provided [nums] should be not null and has at least 2 numbers");
    }
}