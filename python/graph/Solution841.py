# 841. 钥匙和房间
from typing import List


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        # adjacency list
        graph = {}
        for i, adj in enumerate(rooms):
            graph[i] = adj
        visited = [False] * len(rooms)
        # dfs
        def dfs(node):
            if visited[node]:
                return
            visited[node] = True
            adj = graph[node]
            for room in adj:
                dfs(room)
            return
        dfs(0)
        all_visited = True
        for v in visited:
            if not v:
                all_visited = False
                break
        return all_visited
