package lesson;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortRefresh {
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
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int p, int q) {
        if (p >= q) return;

        int i = partition(arr, p, q);

        sort(arr, p, i - 1);
        sort(arr, i + 1, q);
    }

    private static int partition(int[] arr, int p, int q) {
        int x = arr[q];
        int i = p - 1;
        int tmp;

        System.out.println("x = " + x + ", i = " + i);

        for (int j = p; j < q; j++) {
            if (arr[j] <= x) {
                tmp = arr[j];
                arr[j] = arr[++i];
                arr[i] = tmp;
            }
        }
        tmp = arr[i + 1];
        arr[i + 1] = arr[q];
        arr[q] = tmp;

        return i + 1;
    }
}
