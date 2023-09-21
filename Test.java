import java.util.*;

public class Test {
    int f1 = 0;
    int f2 = 0;

    public int b1(int n) {
        if (n == 1) {
            f1 += 1;
            return 2;
        }
        f1 += 1;
        return b1(n / 2) + b1(n / 2) + b1(n / 2) + b1(n / 2);
    }

    public static double bb1(int n) {
        return (1.0 / 3) * n * n - (1.0 / 3);
    }

    public static double f(int n) {
        return 2 * n * n;
    }

    public int b2(int n) {
        if (n == 1) {
            f2 += 1;
            return 2;
        }
        f2 += 1;
        return 4 * b2(n / 2);
    }


    public static void main(String[] args) {
        Test tt = new Test();
        int n = 256;
        System.out.println(tt.b1(n));
        System.out.println(tt.b2(n));
        System.out.println(f(n));
    }

}
