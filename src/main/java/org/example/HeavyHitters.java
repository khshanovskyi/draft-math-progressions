package org.example;

import java.util.HashMap;
import java.util.Map;

public class HeavyHitters {

    public static void main(String[] args) {
        int[] nums = {6, 5, 5, 5, 5, 6, 4, 5, 5, 3, 5};
//        System.out.println(f(nums));

//        a.
//        n = 1000
//        for (int i = 0; i * i < 1000; i++) {
//            System.out.println(i);
//        }
//        i = 1 => i*i
//        i = 2 => i*i
//        i = n => 0
//        i(2) = n
//        op = sqrt(n)

//
//        for (int i = 1_000; i > 1; i/=2) {
//            System.out.println(i);
//        }
//        i = n => n
//        i = n/2 => n/2
//        i = n/4 => n/4
//        ...
//        i = 1 = 1
//
//        n + n/2 + n/4 ... + 1
//        log n + 1
//
//
//        for (int i = 0; i * i < 1_000_000; i++) {
//            System.out.println(i);
//        }

//        c.
//        int c = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 365; j++) {
//                c++;
//            }
//        }
//        System.out.println(c);

//        i = 0 => 365
//        i = 1 => 365
//        i = n - 1 => 365
//        i = n => 0

//        365 + 365 + ... 365 + 0
//        n * 365


//      d.
//        for (int i = 1; i <= n * n - 10; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.println(i);
//            }
//        }
//        i = 1 => 1
//        i = 2 => 2 if n * n - 10 <= i
//        i = n * n - 10 => i
//        1 + 2 + 3 ... + n * n - 10
//
//        d = 1
//        a1 = 1
//        a_n = n * n - 10
//        (n * n - 10) * (n * n - 10 + 1) / 2.
//        n^2 - 10 * n^2 - 9 /2
//        n^4

//      e.
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                for (int k = 1; k <= j; k++) {
//                    System.out.println(i);
//                }
//            }
//        }
//        i = 1 => 1
//        i = 2 => i * i * i
//        ...
//        i = n-1 => i * i * i
//        n^3

//      f.
//        int counter = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j < i; j*=2) {
//                counter++;
//            }
//        }
//        System.out.println(counter);
//        i = 1 => 0
//        i = 2 => 1
//        i = 3 => 1
//        i = 4 => 2
//        i = 5 => 2
//        i = 6 => 3
//        i = n => n * 2
//
//        1 + 1 + 2 + 2 + 3 ...
//        2^0 + 2^1 + 2^3 ... 2^n
//        log2(1) + log2(2) + log2(3)... + log2(2^n)
//        n * (2^n-1)

//      g.
//        int counter = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j < i; j+=i) {
//                counter++;
//            }
//        }
//        i = 1 => 1
//        i = 2 => 1
//        i = 3 => 1
//        ...
//        i = n => n
//        n = n

        c(8, "start ");
//        i = 1 = n
//        i = 2 = n / 2 * 2
//        i = 3 = n / 4 * 2
//        ...
//        i = n - 1 + n / 2 = 1
    }

    private static void c(int n, String s) {
        if (n == 0) return;
        for (int i = 0; i < n; i++) {
            System.out.println(s + i);
        }
        c(n/2, "first rec");
        c(n/2, "second rec");
    }

    private static int f(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int mid = nums.length / 2;
        for (int num : nums) {
            if (map.get(num) > mid) {
                return num;
            }
        }

        throw new RuntimeException("there are no majority number");
    }


    private static int f2(int[] nums) {
        int counter = 0, res = 0;

        for (int num : nums) {
            if (counter == 0) {
                res = num;
                counter++;
            } else if (num != res) {
                counter--;
            } else {
                counter++;
            }
        }

        return res;
    }

}
