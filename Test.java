import java.util.*;

public class Test {

    public int singleNumber(int[] nums) {

        int one = 0;
        int two = 0;

        for (int num : nums) {
            one = one ^ (num & ~two);
            two = two ^ (num & ~one);
        }

        return one;
    }

    public static void main(String[] args) {

        Test tt = new Test();

        int[] n1 = {0,1,0,1,0,1,99};

        int o = tt.singleNumber(n1);

        System.out.println(o);
    }
}
