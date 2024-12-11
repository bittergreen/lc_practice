# 1431. 拥有最多糖果的孩子
from typing import List


class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        k = max(candies) - extraCandies
        return [c >= k for c in candies]

