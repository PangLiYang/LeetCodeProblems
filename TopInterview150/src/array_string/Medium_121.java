package array_string;

public class Medium_121 {
    public int maxProfit(int[] prices) {
        int leastPrice = Integer.MAX_VALUE;
        int curr = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i += 1) {
            if (prices[i] < leastPrice) {
                leastPrice = prices[i];
            }
            curr = prices[i] - leastPrice;
            maxProfit = Math.max(maxProfit, curr);
        }

        return maxProfit;
    }
}
