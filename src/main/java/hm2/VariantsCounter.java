package hm2;

public class VariantsCounter {
    public static int countVariants(int X, int Y, int Z, int W) {
        int[] nums = {X, Y, Z};
        return countVariantsHelper(nums, W, 0);
    }

    private static int countVariantsHelper(int[] nums, int remainingSum, int startIndex) {
        if (remainingSum == 0) {
            return 1;
        }
        int count = 0;
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] <= remainingSum) {
                count += countVariantsHelper(nums, remainingSum - nums[i], i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int X = 10;
        int Y = 25;
        int Z = 15;
        int W = 100;
        int count = countVariants(X, Y, Z, W);
        System.out.println("Number of variants: " + count);
    }
}