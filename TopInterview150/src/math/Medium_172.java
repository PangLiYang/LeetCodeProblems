package math;

public class Medium_172 {

    public int trailingZeroes(int n) {

        int count = 0;
        int fac = 5;

        while (n >= fac) {
            count += n / fac;
            fac *= 5;
        }

        return count;
    }
}
