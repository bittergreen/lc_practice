# 1732. 找到最高海拔
from typing import List


class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        prefix_sum = [0] * (len(gain) + 1)
        for i in range(0, len(gain)):
            prefix_sum[i + 1] = prefix_sum[i] + gain[i]
        return max(prefix_sum)

