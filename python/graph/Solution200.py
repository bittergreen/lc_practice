# 200. 岛屿数量
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None:
            return 0

        rows = len(grid)
        columns = len(grid[0])
        res = 0

        def dfs(r, c):
            if r < 0 or r > (rows - 1) or c < 0 or c > (columns - 1):
                return
            # color it to 0, so won't be revisited
            if grid[r][c] == '1':
                grid[r][c] = '0'
                dfs(r+1, c)
                dfs(r-1, c)
                dfs(r, c+1)
                dfs(r, c-1)
            else:
                return

        for i in range(rows):
            for j in range(columns):
                if grid[i][j] == '1':
                    res += 1
                    dfs(i, j)
        return res
