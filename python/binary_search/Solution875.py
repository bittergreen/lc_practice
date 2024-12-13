# 875. 爱吃香蕉的珂珂
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:

        def canEat(k):
            # k is eating speed
            time = 0
            for pile in piles:
                time += (pile + k - 1) // k
            return time <= h

        left = 1
        right = max(piles)
        while left < right:
            mid = (left + right) // 2
            if canEat(mid):
                right = mid
            else:
                left = mid + 1
        return left
