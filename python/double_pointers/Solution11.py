# 11. 盛最多水的容器
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        res = 0
        left = 0
        right = len(height) - 1
        while left < right:
            area = (right - left) * min(height[right], height[left])
            res = max(area, res)
            if height[right] >= height[left]:
                left += 1
            else:
                right -= 1
        return res

