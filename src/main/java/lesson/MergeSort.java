package lesson;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        sort(arr);

        System.out.println();

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
    }

    private static void sort(int[] arr) {
        sort(arr, arr.length);
    }

    private static void sort(int[] arr, int n) {
        if (n < 2) return;

        int m = n / 2;
        int[] leftArr = new int[m];
        System.arraycopy(arr, 0, leftArr, 0, m);

        int[] rightArr = new int[arr.length - m];
        System.arraycopy(arr, m, rightArr, 0, arr.length - m);

        sort(leftArr, m);
        sort(rightArr, arr.length - m);

        merge(arr, leftArr, rightArr, m, arr.length - m);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr, int leftLength, int rightLength) {
        int a = 0, l = 0, r = 0;

        while (l < leftLength && r < rightLength) {
            if (leftArr[l] <= rightArr[r]) {
                arr[a++] = leftArr[l++];
            } else {
                arr[a++] = rightArr[r++];
            }
        }

        System.arraycopy(leftArr, l, arr, l + r, leftLength - l);
        System.arraycopy(rightArr, r, arr, l + r, rightLength - r);
    }


}
