package array_and_string;

public class Easy_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) {
            return true;
        }

        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                n -= 1;
            }
            return n == 0;
        }

        if (flowerbed.length == 2) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                n -= 1;
            }
            return n == 0;
        }

        for (int i = 0; i < flowerbed.length; i += 1) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n -= 1;
                    flowerbed[i] = 1;
                }
                continue;
            }

            if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    n -= 1;
                    flowerbed[i] = 1;
                }

                if (n == 0) {
                    return true;
                }

                continue;
            }

            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                n -= 1;
                flowerbed[i] = 1;
            }

            if (n == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Easy_605 test = new Easy_605();
        int[] arr = new int[]{0,0,0,0,0,1,0,0};
        int num = 0;
        System.out.println(test.canPlaceFlowers(arr, num));
    }
}
