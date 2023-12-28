public class dp_ponyless {

    private static int[][] ponylessA(int[][] a) {
        int n = a.length;

        int[][] b = new int[n][n];

        for (int i = 0; i < n; i += 1) {
            b[i][0] = -1 * (a[i][0] - 1);
        }

        for (int j = 0; j < n; j += 1) {
            b[0][j] = -1 * (a[0][j] - 1);
        }

        for (int i = 1; i < n; i += 1) {
            for (int j = 1; j <n; j += 1) {

                if (a[i][j] == 1) {
                    b[i][j] = 0;
                    continue;
                }

                b[i][j] = 1;

                int k = b[i - 1][j - 1];

                for (int h = 1; h < k + 1; h += 1) {

                    if (a[i - h][j] == 0 && a[i][j - h] ==0) {
                        b[i][j] += 1;
                    } else {
                        break;
                    }
                }
            }
        }

        return b;
    }

    private static int[][] ponylessB(int[][] a) {
        int n = a.length;

        int[][] b = new int[n][n];

        for (int i = 0; i < n; i += 1) {
            b[i][0] = -1 * (a[i][0] - 1);
        }

        for (int j = 0; j < n; j += 1) {
            b[0][j] = -1 * (a[0][j] - 1);
        }

        for (int i = 1; i < n; i += 1) {
            for (int j = 1; j <n; j += 1) {

                if (a[i][j] == 1) {
                    b[i][j] = 0;
                    continue;
                }

                int k = Math.min(b[i - 1][j], b[i][j - 1]);

                b[i][j] = k;

                if (a[i - k][j - k] == 0) {
                    b[i][j] += 1;
                }
            }
        }

        return b;
    }


    public static void main(String[] args) {

        int[][] a = {{0, 1, 0, 0},
                     {1, 1, 0, 0},
                     {1, 0, 0, 0},
                     {0, 1, 0, 0}};

        int[][] aa = ponylessA(a);
        int[][] bb = ponylessB(a);


        for (int[] j : aa) {
            for (int i : j) {
                System.out.print(i + ",");
            }
            System.out.println();
        }

        System.out.println();

        for (int[] j : bb) {
            for (int i : j) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
