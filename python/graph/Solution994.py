# 994. 腐烂的橘子
from collections import deque
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
        m = len(grid)
        n = len(grid[0])
        # BFS to solve
        queue = deque()
        fresh_cnt = 0
        minute = 0
        for i in range(m):
            for j in range(n):
                value = grid[i][j]
                if value == 1:
                    fresh_cnt += 1
                elif value == 2:
                    queue.append((i, j))
        if fresh_cnt == 0:
            return 0

        while queue:
            for _ in range(len(queue)):
                # rot
                r, c = queue.popleft()
                for next_r, next_c in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
                    if 0 <= next_r < m and 0 <= next_c < n and grid[next_r][next_c] == 1:
                        grid[next_r][next_c] = 2
                        fresh_cnt -= 1
                        queue.append((next_r, next_c))
            minute += 1

        if fresh_cnt == 0:
            return minute - 1
        else:
            return -1
