# 1. 两数之和
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        tool = {}
        for i, num in enumerate(nums):
            if num in tool:
                return [tool[num], i]
            tool[target - num] = i
