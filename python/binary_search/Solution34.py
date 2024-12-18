# 34. 在排序数组中查找元素的第一个和最后一个位置
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or target < nums[0] or target > nums[-1]:
            return [-1, -1]
        res = [-1, -1]
        # find the first element that >= target
        left = 0
        right = len(nums)
        while left < right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid
        if nums[left] == target:
            res[0] = left
        # find the first element that <= target
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = (left + right + 1) // 2
            if nums[mid] > target:
                right = mid - 1
            else:
                left = mid
        if nums[left] == target:
            res[1] = left
        return res
