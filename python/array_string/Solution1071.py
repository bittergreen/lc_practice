# 1071. 字符串的最大公因子
import math


class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        if str1 + str2 != str2 + str1:
            return ""

        # 计算最大公约数的长度
        gcd_len = math.gcd(len(str1), len(str2))

        # 返回 str1 的前 gcd_len 长度的子串
        return str1[:gcd_len]
