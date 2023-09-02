package array_string;

public class Medium_122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lowPrice = Integer.MAX_VALUE;
        int revenue = 0;

        for (int i = 0; i < n; i += 1) {
            if (prices[i] < lowPrice) {
                lowPrice = prices[i];
            } else if (prices[i] > lowPrice) {
                revenue += prices[i] - lowPrice;
                lowPrice = prices[i];
            }
        }

        return revenue;
    }
}
