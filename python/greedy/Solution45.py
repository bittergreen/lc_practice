# 45. 跳跃游戏 II
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 0
        jumps = 0
        cur_range = 0
        max_reach = 0

        for pos, step in enumerate(nums):
            max_reach = max(max_reach, pos + step)
            if pos == cur_range:
                cur_range = max_reach
                jumps += 1
                if max_reach >= len(nums) - 1:
                    return jumps
        return jumps
