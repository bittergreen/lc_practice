# 35. 搜索插入位置
from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target > nums[-1]:
            return len(nums)
        if target < nums[0]:
            return 0
        left = 0
        right = len(nums) - 1
        while right > left + 1:
            mid = (left + right) // 2
            if target > nums[mid]:
                left = mid
            elif target < nums[mid]:
                right = mid
            else:
                return mid
        if nums[left] < target < nums[right]:
            return right
        if target == nums[left]:
            return left
        else:
            return right

    def searchInsert2(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while right >= left:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return left


if __name__ == '__main__':
    sol = Solution()
    print(sol.searchInsert([1,3,5,6], 5))

