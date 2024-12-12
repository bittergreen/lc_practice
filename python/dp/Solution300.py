# 300. 最长递增子序列
from typing import List


class Solution:
    def lengthOfLISDP(self, nums: List[int]) -> int:
        # for j < i, if nums[i] > nums[j], then dp[i] = max(dp[i], dp[j]+1)
        dp = [1] * len(nums)
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)

    def lengthOfLIS(self, nums: List[int]) -> int:
        # binary search
        res = []

        def binary_search(arr, k):
            # find first position in arr that >= k
            left, right = 0, len(arr)
            while left < right:
                mid = (left + right) // 2
                if arr[mid] >= k:
                    right = mid
                else:
                    left = mid + 1
            return left

        for num in nums:
            pos = binary_search(res, num)
            if pos == len(res):
                res.append(num)
            else:
                res[pos] = num
        return len(res)


if __name__ == '__main__':
    nums = [10, 9, 2, 5, 3, 7, 101, 18]
    sol = Solution()
    print(sol.lengthOfLIS(nums))
