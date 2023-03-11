package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class SortTheStudentsByTheirKthScore {

    public static void main(String[] args) {
        int[][] arr = {{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}};
//        int[][] score = sortTheStudents2(arr, 2);

//        int[] ints;
//        for (int i = 0; i < score.length; i++) {
//            ints = score[i];
//            for (int j = 0; j < ints.length; j++) {
//                System.out.print(ints[j] + ", ");
//            }
//            System.out.println();
//        }

        int[] ints;
        for (int i = 0; i < arr.length; i++) {
            ints = arr[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + ", ");
            }
            System.out.println();
        }
        System.out.println();

        int m = arr.length;
        int n = arr[0].length;

        int[][] transposedMatrix = new int[n][m];
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                transposedMatrix[x][y] = arr[y][x];
            }
        }

        for (int i = 0; i < transposedMatrix.length; i++) {
            ints = transposedMatrix[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + ", ");
            }
            System.out.println();
        }


    }
    public static int[][] sortTheStudents2(int[][] A, int k) {
        Arrays.sort(A, (a, b) -> b[k] - a[k]);
        return A;
    }

    /*
    Input: score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]], k = 2
    Output: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
    Explanation: In the above diagram, S denotes the student, while E denotes the exam.
    - The student with index 1 scored 11 in exam 2, which is the highest score, so they got first place.
    - The student with index 0 scored 9 in exam 2, which is the second highest score, so they got second place.
    - The student with index 2 scored 3 in exam 2, which is the lowest score, so they got third place.
     */
    public static int[][] sortTheStudents(int[][] score, int k) {
        int[] ints;
        int[] examColumn = new int[score.length];
        int[][] res = new int[score.length][score[0].length];

        for (int i = 0; i < score.length; i++) {
            ints = score[i];
            for (int j = 0; j < ints.length; j++) {
                if (j == k) {
                    examColumn[i] = ints[j];
                }
            }
        }

        reversedSort(examColumn);

        for (int i = 0; i < examColumn.length; i++) {
            for (int[] value : score) {
                ints = value;
                if (examColumn[i] == ints[k]) {
                    res[i] = ints;
                    break;
                }
            }
        }

        return res;
    }

    private static void reversedSort(int... arr) {
        int length = arr.length;
        int tmp;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arr[j-1] < arr[j]){
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

}
