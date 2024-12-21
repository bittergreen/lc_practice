# 33. 搜索旋转排序数组
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums is None:
            return -1
        last = float('-inf')
        index = -1
        # index i is the place where nums[0] is
        for i, num in enumerate(nums):
            if num < last:
                index = i
                break
            else:
                last = num
        if index == -1:
            arr1 = nums
            arr2 = []
        else:
            arr1 = nums[:index]
            arr2 = nums[index:]

        def binary_search(arr, target):
            if not arr:
                return -1
            if target < arr[0] or target > arr[-1]:
                return -1
            left = 0
            right = len(arr) - 1
            while left <= right:
                mid = (left + right) // 2
                if arr[mid] == target:
                    return mid
                elif arr[mid] > target:
                    right = mid - 1
                else:
                    left = mid + 1
            if arr[left] == target:
                return left
            else:
                return -1

        res1 = binary_search(arr1, target)
        res2 = binary_search(arr2, target)

        if res1 != -1:
            return res1
        if res2 != -1:
            return res2 + index
        return -1


if __name__ == '__main__':
    nums = [1, 3]
    target = 3
    sol = Solution()
    print(sol.search(nums, target))
