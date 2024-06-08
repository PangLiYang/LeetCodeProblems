package math;

public class Medium_50 {

    public double myPow(double x, int n) {

        if (n < 0) {
            n = -n;
            x =  1 / x;
        }

        double ret = 1;

        while (n != 0) {
            if ((n & 1) != 0) {
                ret *= x;
            }

            x *= x;
            n >>>= 1;
        }

        return ret;
    }
}
