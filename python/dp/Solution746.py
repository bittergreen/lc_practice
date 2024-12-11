# 746. 使用最小花费爬楼梯
from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
        # calculate the cost of len(cost)+1 -th element
        if len(cost) == 0:
            return 0
        if len(cost) == 1:
            return cost[0]
        dp = [0] * (len(cost)+1)
        dp[0] = 0
        dp[1] = 0
        for i in range(2, len(cost)+1):
            dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
        return dp[-1]


if __name__ == '__main__':
    sol = Solution()
    print(sol.minCostClimbingStairs([1,100,1,1,1,100,1,1,100,1]))
