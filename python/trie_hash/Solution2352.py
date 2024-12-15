# 2352. 相等行列对
from typing import List


class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        rows = [tuple(grid[i]) for i in range(len(grid))]
        columns = [tuple(grid[i][j] for i in range(len(grid))) for j in range(len(grid[0]))]
        cnt = 0
        for row in rows:
            for col in columns:
                if row == col:
                    cnt += 1
        return cnt

