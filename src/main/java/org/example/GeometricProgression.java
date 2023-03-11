package org.example;

public class GeometricProgression {

    public static void main(String[] args) {
        System.out.println(defineGeometricProgression(18, 6));
    }

    private static int defineGeometricProgression(int... nums) {
        if (nums != null && nums.length > 1) {
            int q = nums[1] / nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i + 1] / nums[i] != q) {
                    throw new IllegalStateException("Provided [nums] doesn't have geometric progression...");
                }
            }
            return q;
        }
        throw new IllegalArgumentException("Provided [nums] should be not null and has at least 2 numbers");
    }
}
