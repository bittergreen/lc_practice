# 1143. 最长公共子序列


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        # dp[i][j] = dp[i-1][j-1] + 1, if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]), if text1[i] != text2[j]
        if (not text1) or (not text2):
            return 0
        l1 = len(text1)
        l2 = len(text2)
        dp = [[0] * l2 for _ in range(l1)]
        dp[0][0] = 1 if text1[0] == text2[0] else 0
        # deal with boarders
        for i in range(1, l1):
            dp[i][0] = 1 if text1[i] == text2[0] else dp[i-1][0]
        for j in range(1, l2):
            dp[0][j] = 1 if text1[0] == text2[j] else dp[0][j-1]
        for i in range(1, l1):
            for j in range(1, l2):
                if text1[i] == text2[j]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return dp[-1][-1]
