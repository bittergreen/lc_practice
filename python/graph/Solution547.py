# 547. 省份数量
from typing import List


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        if not isConnected:
            return 0
        amt = 0
        n = len(isConnected)
        visited = [False] * n

        # dfs
        def dfs(city):
            if visited[city]:
                return
            visited[city] = True
            for next_city in range(n):
                if isConnected[city][next_city]:
                    dfs(next_city)
            return

        for city in range(n):
            if not visited[city]:
                dfs(city)
                amt += 1
        return amt
