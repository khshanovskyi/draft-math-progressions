package lesson;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class HeapSort {

    public static void main(String[] args) {
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = ThreadLocalRandom.current().nextInt(1, 100);
//        }
        int[] arr = {9, 0, 18, 68, 7, 30, 33, 77, 30, 16};

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        sort(arr);

        System.out.println();

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
    }

    private static void sort(int... arr) {
        int n = arr.length - 1;
        int[] res = new int[arr.length];
        int counter = 0;

        for (int i = n / 2 - 1; i >= 0; i--) {
            toHeap(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            res[counter++] = arr[0];
            arr[0] = arr[n];
            arr[n] = 0;
            n--;
            toHeap(arr, n, 0);
        }

        n = arr.length - 1;
        for (int i = 0; i < n / 2 + 1; i++) {
            arr[i] = res[n - i];
            arr[n - i] = res[i];
        }
    }

    private static void toHeap(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int tmp;

        if (left <= n && arr[left] > arr[largest]) largest = left;
        if (right <= n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            toHeap(arr, n, largest);
        }
    }

}
