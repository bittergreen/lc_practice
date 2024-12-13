# 74. 搜索二维矩阵
from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if target < matrix[0][0] or target > matrix[-1][-1]:
            return False
        # search vertically
        v_index = -1
        left = 0
        right = len(matrix) - 1
        while left <= right:
            mid = (left + right) // 2
            if matrix[mid][0] <= target <= matrix[mid][-1]:
                v_index = mid
                break
            elif target > matrix[mid][-1]:
                left = mid + 1
            else:
                right = mid - 1
        if v_index == -1:
            return False
        # search horizontally
        left = 0
        right = len(matrix[0]) - 1
        while left <= right:
            mid = (left + right) // 2
            if target == matrix[v_index][mid]:
                return True
            elif target > matrix[v_index][mid]:
                left = mid + 1
            else:
                right = mid - 1
        return False

