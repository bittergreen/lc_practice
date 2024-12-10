// 122. 买卖股票的最佳时机 II
public class Solution7 {

    public int maxProfit(int[] prices) {

        int totalProfit = 0;
        for (int i=1; i<prices.length; i++) {
            totalProfit += prices[i] > prices[i-1] ? prices[i] - prices[i-1] : 0;
        }

        return totalProfit;

    }

}
