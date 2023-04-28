package lesson;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class CombSort {

    private final static float FACTOR = 1.247f;

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }

        sort(arr);

        System.out.println();

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int... arr) {
        int length = arr.length;
        int step = length / 2;
        int tmp;

        while (step >= 1) {
            for (int i = 0; i + step < length; i++) {
                if (arr[i] > arr[i + step]) {
                    tmp = arr[i];
                    arr[i] = arr[i + step];
                    arr[i + step] = tmp;
                }
            }
            step = (int) (step / FACTOR);
            System.out.println(step);
        }
    }
}
