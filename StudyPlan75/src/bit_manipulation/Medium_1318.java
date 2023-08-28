package bit_manipulation;

public class Medium_1318 {
    public int minFlips(int a, int b, int c) {
        int answer = 0;
        for (int i = 0; i < 32; i += 1) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if (bitC == 0) {
                if (bitA == 1) {
                    answer += 1;
                }
                if (bitB == 1) {
                    answer += 1;
                }
            } else {
                if (bitA == 0 && bitB == 0) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
