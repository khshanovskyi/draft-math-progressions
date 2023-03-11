package leetcode;

import java.util.Arrays;

public class SortTheMatrixDiagonally {

    public static void main(String[] args) {
        int[][] arr =
          {{11, 25, 66, 19, 69, 71, 15},
            {23, 55, 17, 45, 15, 52, 31},
            {75, 31, 36, 44, 58, 28, 26},
            {22, 27, 33, 25, 68, 41, 17},
            {84, 28, 14, 11, 52, 50, 10}};

        int[] ints;
        for (int i = 0; i < arr.length; i++) {
            ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] res = diagonalSort(arr);

        for (int i = 0; i < res.length; i++) {
            ints = res[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + ", ");
            }
            System.out.println();
        }
    }


    public static int[][] diagonalSort(int[][] mat) {
        int columnLength = mat.length;
        int rowLength = mat[0].length;
        int x, y;
        int length = Math.min(columnLength, rowLength);

        int[] ints;
        int idx;
        for (int i = 0; i < columnLength; i++) {
            x = i;
            y = 0;
            idx = 0;
            ints = new int[length];
            while (x < columnLength && y < rowLength) {
                ints[idx] = mat[x][y];
                x++;
                y++;
                idx++;
            }
            sort(ints);
            x = i;
            y = 0;
            idx = 0;
            while (x < columnLength && y < rowLength) {
                if (ints[idx] != 0) {
                    mat[x][y] = ints[idx];
                    x++;
                    y++;
                }
                idx++;
            }
        }

        for (int j = 0; j < rowLength; j++) {
            x = 0;
            y = j;
            idx = 0;
            ints = new int[length];
            while (x < columnLength && y < rowLength) {
                ints[idx] = mat[x][y];
                x++;
                y++;
                idx++;
            }
            sort(ints);
            x = 0;
            y = j;
            idx = 0;
            while (x < columnLength && y < rowLength) {
                if (ints[idx] != 0){
                    mat[x][y] = ints[idx];
                    x++;
                    y++;
                }
                idx++;
            }
        }

        return mat;
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


}
