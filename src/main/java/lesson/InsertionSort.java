package lesson;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }

        sort(arr);

        System.out.println();

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int ... arr) {
        int tmp;
        int idx;
        for (int i = 0; i < arr.length; i++) {
            idx = i;
            while (idx>0 && arr[idx - 1] > arr[idx]) {
                tmp = arr[idx - 1];
                arr[idx - 1] = arr[idx];
                arr[idx] = tmp;
                idx--;
            }
        }

    }
}
