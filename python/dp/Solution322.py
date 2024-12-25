# 322.coin change
import sys
from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp[i] = min(dp[i], dp[i-coins[j]]+1)
        if amount == 0:
            return 0
        dp = [sys.maxsize] * (amount+1)
        dp[0] = 0
        for i in range(1, amount+1):
            for j in range(len(coins)):
                if coins[j] <= i:
                    dp[i] = min(dp[i], dp[i-coins[j]]+1)
        return -1 if dp[amount] == sys.maxsize else dp[amount]


if __name__ == '__main__':
    sol = Solution()
    print(sol.coinChange([1, 2, 5], 11))
