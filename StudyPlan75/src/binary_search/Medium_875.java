package binary_search;

public class Medium_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int lb = 1;
        int ub = 0;
        int ans;

        for (int pile: piles) {
            ub = Math.max(ub, pile);
        }

        while (lb <= ub) {
            ans = lb + (ub - lb) / 2;
            if (checkTime(piles, ans) <= h && checkTime(piles, ans - 1) > h) {
                return ans;
            } else if (checkTime(piles, ans) > h) {
                lb = ans + 1;
            } else {
                ub = ans - 1;
            }
        }

        return -1;
    }

    private int checkTime(int[] piles, int speed) {
        int time = 0;
        for (int pile: piles) {
            time += (int) Math.ceil((1.0 * pile) / speed);
        }

        return time;
    }
}
