# 杨辉三角
from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        # dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        dp = [[1]]
        for i in range(1, numRows):
            row = [1]
            for j in range(1, i):
                row.append(dp[i-1][j-1] + dp[i-1][j])
            row.append(1)
            dp.append(row)
        return dp


if __name__ == '__main__':
    sol = Solution()
    print(sol.generate(1))

