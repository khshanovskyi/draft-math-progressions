package lesson;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }

        sedgwickSort(arr);

        System.out.println();

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort(int... arr) {
        int length = arr.length;
        int tmp, idx, step = length / 2;

        while (step > 0) {
            for (int i = step; i < length; i++) {
                idx = i;
                while (idx > 0 && arr[idx - 1] > arr[idx]) {
                    tmp = arr[idx - 1];
                    arr[idx - 1] = arr[idx];
                    arr[idx] = tmp;
                    idx--;
                }
            }
            step = step / 2;
        }
    }

    public static void sedgwickSort(int... arr) {
        int length = arr.length;
        int step = 1;

        for (int i = 0; i * 3 < length; i++) {
            if (i % 2 == 0) {
                //pair
                step = 9 * (int) Math.pow(2, i) - 9 * (int) Math.pow(2, i / 2) + 1;
            } else {
                //not pair
                step = 8 * (int) Math.pow(2, i) - 6 * (int) Math.pow(2, (i + 1) / 2) + 1;
            }
            if (step * 3 > length) break;
            sort(step, arr);
        }
    }

    public static void sort(int step, int... arr) {
        int idx, tmp;
        for (int i = step; i < arr.length; i++) {
            idx = i;
            while (idx > 0 && arr[idx - 1] > arr[idx]) {
                tmp = arr[idx - 1];
                arr[idx - 1] = arr[idx];
                arr[idx] = tmp;
                idx--;
            }
        }
    }
}
