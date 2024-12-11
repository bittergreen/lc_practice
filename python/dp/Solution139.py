# 139. 单词拆分
from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # dp[i] = False | (dp[i] - wordDict[j])
        wordDict = set(wordDict)
        length = len(s)
        max_check_range = max(map(len, wordDict))
        dp = [False] * (length+1)
        dp[0] = True
        for i in range(length):
            if not dp[i]:
                continue
            for j in range(i+1, min(length+1, i+1+max_check_range)):
                if dp[i] and (s[i:j] in wordDict):
                    dp[j] = True
        return dp[-1]

