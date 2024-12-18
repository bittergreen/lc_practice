# 1768. 交替合并字符串

class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res = ""
        l1 = len(word1)
        l2 = len(word2)

        for i in range(min(l1, l2)):
            res += word1[i] + word2[i]

        res += word1[i + 1:] + word2[i + 1:]
        return res

