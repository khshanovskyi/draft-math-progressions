package leetcode;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {

    public static void main(String[] args) {
//        int[] seats = {3,1,5};
//        int[] students = {2,7,4};
//        int[] seats = {4, 1, 5, 9};
//        int[] students = {1, 3, 2, 6};
//        int[] seats = {2, 2, 6, 6};
//        int[] students = {1, 3, 2, 6};
        int[] seats = {12,14,19,19,12};
        int[] students = {19,2,17,20,7};

        System.out.println(minMovesToSeat(seats, students));
        System.out.println(minMovesToSeat2(seats, students));
    }

    private static int minMovesToSeat(int[] seats, int[] students) {
        int counter = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != students[i]) {
                if (seats[i] > students[i]) {
                    counter = counter + (seats[i] - students[i]);
                } else {
                    counter = counter + (students[i] - seats[i]);
                }
            }
        }

        return counter;
    }

    private static int minMovesToSeat2(int[] seats, int[] students) {
        int counter = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; i++) {
            counter += Math.abs(seats[i] - students[i]);
        }

        return counter;
    }

}
