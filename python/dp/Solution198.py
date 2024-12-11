# 打家劫舍
from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        # dp[i] = max(dp[i-1], dp[i-2]+nums[i])
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        return dp[-1]

    def robUp(self, nums):
        # save space
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        a = nums[0]
        b = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            tmp = max(b, a + nums[i])
            a = b
            b = tmp
        return b


if __name__ == '__main__':
    sol = Solution()
    print(sol.rob([1, 2, 3, 1]))
    print(sol.rob([2, 7, 9, 3, 1]))
