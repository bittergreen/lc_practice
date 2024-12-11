#  279. 完全平方数
class Solution:
    def numSquares(self, n: int) -> int:
        # dp[i] = min(dp[i], dp[i-j*j] + 1)
        dp = [0] * (n + 1)
        for i in range(n+1):
            dp[i] = i
            j = 1
            while j * j <= i:
                dp[i] = min(dp[i], dp[i-j*j] + 1)
                j += 1
        return dp[n]


if __name__ == '__main__':
    sol = Solution()
    print(sol.numSquares(13))
