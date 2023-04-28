package lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        sort(arr, 6);

        System.out.println();

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
    }

    private static void sort(int[] arr, int k) {
        int min = arr[0], max = arr[0];

        for (int i : arr) {
            if (min > i) min = i;
            if (max < i) max = i;
        }

        int l = Math.floorDiv((max - min), k);
        List<Integer>[] container = new ArrayList[k + 1];

        int lNum;
        for (int i : arr) {
            lNum = Math.floorDiv((i - min), l);
            if (container[lNum] != null) {
                add(container[lNum], i);
            } else {
                List<Integer> values = new ArrayList<>();
                values.add(i);
                container[lNum] = values;
            }
        }

        int tmp = 0;
        for (List<Integer> values : container) {
            if (values != null) {
                for (Integer i : values) {
                    System.out.println(i);
                    arr[tmp++] = i;
                }
            }
        }
        System.out.println();
    }

    private static void add(List<Integer> values, int i) {
        int l = values.size();
        for (int j = 0; j < values.size(); j++) {
            if (i < values.get(j)) {
                values.add(j, i);
                break;
            }
        }
        if (l == values.size()) {
            values.add(i);
        }
    }
}
