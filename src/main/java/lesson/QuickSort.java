package lesson;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        sort(arr);

        System.out.println();

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
    }

    public static void sort(int... arr) {
        sort(0, arr.length - 1, arr);
    }

    public static void sort(int p, int q, int... arr) {
        if (p >= q) return;

        int c = partition(p, q, arr);

        sort(p, c - 1, arr);
        sort(c + 1, q, arr);
    }

    private static int partition(int p, int q, int... arr) {
        int pivot = arr[q];
        int tmp, c = p - 1;
        for (int i = p; i < q; i++) {
            if (arr[i] <= pivot) {
                tmp = arr[i];
                arr[i] = arr[++c];
                arr[c] = tmp;
            }
        }
        tmp = arr[c + 1];
        arr[c + 1] = arr[q];
        arr[q] = tmp;
        return c + 1;
    }

}
