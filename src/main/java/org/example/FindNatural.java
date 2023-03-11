package org.example;

public class FindNatural {

    public static void main(String[] args) {
        System.out.println(f(6.55));
    }

    private static int f(double d){
        for (int i = 2; i < 101; i++) {
           double m = d * i;
            String s = String.valueOf(m).split("\\.")[1];
            if (s.equals("0")) {
                return i;
            }
        }
        return 0;
    }

    /*
    log   8^2 = 1.5 * 2 => 3^3 < 8^2
        3

    log   8^10  = 1.9 * 10 => 3^19 > 8^10
        3

    log   8^20 = 1.85 * 20 => 3^37 < 8^20
        3

    log   8^25 = 1.88 * 25 => 3^47 < 8^25
        3

    IF      log   8^10  = 1.9 * 10 => 3^19 > 8^10   &&     log   8^25 = 1.88 * 25 => 3^47 < 8^25
                3                                              3

    THEN    log 8 ~~ 1.89
               3
     */


     /*
    log   13^2 = 1.5 * 2 => 4^3 < 13^2
        4

    log   13^10  = 1.9 * 10 => 4^19 > 13^10
        4

    log   13^20 = 1.85 * 20 => 4^37 < 13^20
        4

    IF      log   13^10  = 1.9 * 10 => 4^19 > 13^10   &&     log  13^25 = 1.85 * 20 => 4^47 < 13^25
                4                                                4

    THEN    log 13 ~~ in range (1.86 to 1.89)
               4
     */


       /*

    log   17^2 = 2.5 * 2 => 3^5 < 17^2
        3

    log   17^5 = 2.6 * 5 => 3^13 > 17^5
        3


    log 17 ~~ in range (2.51 to 2.59)
       3

     */

    /*

    log  1 = 0
       11

    log   11 = 0.5 (1/2)
       121

    log   1/4 = ??
       1/2

    log 1/7 = -1
       7

    log    (3^2 * 4) = 2/2 = 1 (9*4=36, 6^2=36)
       6^2

    log       12-5 => log        12-5 => log 7 = 1
       49(1/2)           sqrt(49)           7


    12^log  98 = 98^log  12 = 1 ==== ??????
          12           12

     */

}
