# 爬楼梯
class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0] * (n+1)
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]

    def climbStairsUp(self, n):
        # dp[i] = dp[i-1] + dp[i-2]
        if n == 1:
            return 1
        prev, cur = 1, 1
        for i in range(2, n+1):
            prev, cur = cur, prev + cur
        return cur
