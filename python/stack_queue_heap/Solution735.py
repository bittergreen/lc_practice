# 735. 小行星碰撞
from typing import List


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for a in asteroids:
            while stack and a < 0 < stack[-1]:
                # collision happens
                crasher = stack[-1]
                if a + crasher == 0:
                    stack.pop()
                elif a + crasher < 0:
                    stack.pop()
                    continue
                break
            else:
                stack.append(a)
        return stack

