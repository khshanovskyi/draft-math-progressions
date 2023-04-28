package lesson;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 18, 68, 7, 30, 33, 77, 30, 16};

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        sort(arr);

        System.out.println();

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
    }

    private static void sort(int... arr) {
        int length = arr.length;
        String[] strArr = new String[length];
        int maxLength = 0;
        String nil = "0";
        for (int i = 0; i < length; i++) {
            strArr[i] = String.valueOf(arr[i]);
            if (strArr[i].length() > maxLength) maxLength = strArr[i].length();
        }

        for (int i = 0; i < length; i++) {
            strArr[i] = nil.repeat(maxLength - strArr[i].length()) + strArr[i];
        }

        if (maxLength - 1 >= 0) maxLength = maxLength - 1;

        int idx;
        String tmp;
        for (int idxEl = maxLength; idxEl >= 0; idxEl--) {
            for (int i = 1; i < length; i++) {
                idx = i;
                while (idx > 0 && strArr[idx - 1].charAt(idxEl) > strArr[idx].charAt(idxEl)) {
                    tmp = strArr[idx - 1];
                    strArr[idx - 1] = strArr[idx];
                    strArr[idx] = tmp;
                    idx--;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
    }
}
