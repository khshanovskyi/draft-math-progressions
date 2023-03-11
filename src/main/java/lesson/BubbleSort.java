package lesson;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
//        int[] arr = new int[30];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = ThreadLocalRandom.current().nextInt(1, 20);
//        }

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10};

//        shakeSort2(arr);
//
//        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(count(11, arr));

    }

    private static void sort(int... arr) {
        int tmp;
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

    private static int count(int num, int... arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num) {
                System.out.println("in count");
                counter++;
            }
        }
        return counter;
    }

    private static void shakeSort(int... arr) {
        int tmpRight;
        int tmpLeft;

        int rightInx;
        int leftInx;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    tmpRight = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmpRight;
                }
                rightInx = arr.length - 1 - j;
                leftInx = arr.length - 2 - j;
                if (leftInx >= 0 && arr[rightInx] < arr[leftInx]) {
                    tmpLeft = arr[leftInx];
                    arr[leftInx] = arr[rightInx];
                    arr[rightInx] = tmpLeft;
                }
            }
        }
    }

    private static void shakeSort2(int... arr) {
        int tmpRight = arr.length;
        int tmpLeft = 0;
        int tmp;
        while (tmpLeft < tmpRight) {
            Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
            System.out.println();
            for (int j = tmpLeft + 1; j < tmpRight; j++) {
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }

            tmpRight--;
            for (int j = tmpRight; j > tmpLeft; j--) {
                if (arr[j - 1] > arr[j]) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
            tmpLeft++;
        }
    }
}
