# 53. 最大子数组和
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur_sum = nums[0]
        max_sum = nums[0]
        for i in range(1, len(nums)):
            # dp[i] = max(dp[i-1]+nums[i], nums[i])
            cur_sum = max(nums[i] + cur_sum, nums[i])
            max_sum = max(cur_sum, max_sum)
        return max_sum
