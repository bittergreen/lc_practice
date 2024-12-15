# 207. 课程表
from collections import deque
from typing import List


class Solution:
    def canFinishDFS(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # pre -> course edges
        adj_list = {i: [] for i in range(numCourses)}
        for course, pre in prerequisites:
            adj_list[course].append(pre)
        # 0: not visited, 1: visiting, 2:visited
        visited = [0] * numCourses

        def dfs(node):
            if visited[node] == 2:
                return True
            if visited[node] == 1:
                return False
            if visited[node] == 0:
                visited[node] = 1
                for pre in adj_list[node]:
                    if not dfs(pre):
                        return False
                visited[node] = 2
                return True

        for i in range(numCourses):
            if not dfs(i):
                return False
        return True

    def canFinishBFS(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # pre->course edge
        adj_list = {i: [] for i in range(numCourses)}
        in_degrees = [0 for _ in range(numCourses)]
        queue = deque()
        for course, pre in prerequisites:
            adj_list[pre].append(course)
            in_degrees[course] += 1
        # all courses with indegree of 0
        for i, indegree in enumerate(in_degrees):
            if indegree == 0:
                queue.append(i)
        # bfs
        while queue:
            pre = queue.popleft()
            numCourses -= 1
            for c in adj_list[pre]:
                in_degrees[c] -= 1
                if not in_degrees[c]:
                    queue.append(c)
        return numCourses == 0



