# 649. Dota2 参议院
from collections import deque


class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        r_deque = deque()
        d_deque = deque()

        for i, char in enumerate(senate):
            if char == 'R':
                r_deque.append(i)
            elif char == 'D':
                d_deque.append(i)

        while r_deque and d_deque:
            r_now = r_deque.popleft()
            d_now = d_deque.popleft()
            if r_now < d_now:
                r_deque.append(r_now + len(senate))
            else:
                d_deque.append(d_now + len(senate))

        return "Radiant" if r_deque else "Dire"

