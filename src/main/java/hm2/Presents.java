package hm2;

public class Presents {

    public static void main(String[] args) {

        System.out.println(f(10, 25, 15,40));
    }

    private static int f(int x, int y, int z, int w) {
        int counter = count(x,w) + count(y, w) + count(z, w);
        int acc_x = x;
        int acc_y = y;
        int acc_z = z;
        int acc_xy = 0;


        while (true) {
            if (x + acc_x < w) {
//                acc_x = s
            } else if (x + acc_x == w) {
                acc_x += x;
                counter++;
            }

            if (y + acc_y < w) {
                acc_y += y;
            } else if (y + acc_y == w) {
                acc_y += y;
                counter++;
            }

            if (acc_xy + x + y < w) {
                acc_xy = acc_xy + x + y;
            } else if (acc_xy + x + y == w) {
                acc_xy = acc_xy + x + y;
                counter++;
            } else {
                break;
            }

        }

        return counter;
    }

    private static int count(int i, int w) {
        int acc = i;
        int counter = 0;

        while (true){
            if (i + acc < w) {
                acc += i;
            } else if (i + acc == w) {
                acc += i;
                counter++;
            }else {
                break;
            }
        }

        return counter;
    }

    private static int count(int i, int j, int w) {
        return 0;
    }
}
