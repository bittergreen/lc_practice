# 714. 买卖股票的最佳时机含手续费

from typing import List

class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        # dp[i][0]: 第i天不持有的最大利润 & dp[i][1]: 第i天持有的最大利润
        # dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] - fee)
        # dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
        # dp[0][0] = 0, dp[0][1] = -prices[0]
        n = len(prices)
        dp = [0, -prices[0]]
        for i in range(1, n):
            tmp = dp[0]
            dp[0] = max(dp[0], dp[1] + prices[i] - fee)
            dp[1] = max(dp[1], tmp - prices[i])
        return dp[0]
