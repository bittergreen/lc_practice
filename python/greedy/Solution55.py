# 55. 跳跃游戏
from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0

        for i, extra_distance in enumerate(nums):
            if i > max_reach:
                return False
            max_reach = max(max_reach, i + extra_distance)
            if max_reach >= len(nums) - 1:
                return True
        return max_reach >= len(nums) - 1
