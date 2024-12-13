# 128. 最长连续序列
from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        tool = set(nums)
        longest = 0
        for num in nums:
            if (num - 1) not in tool:
                cur_num = num
                cur_length = 1
                while (cur_num + 1) in tool:
                    cur_num += 1
                    cur_length += 1
                longest = max(longest, cur_length)
        return longest
