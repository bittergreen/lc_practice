# 2300. 咒语和药水的成功对数
from typing import List


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        n = len(spells)
        m = len(potions)
        pairs = [0] * n
        potions = sorted(potions)

        for i, spell in enumerate(spells):
            target = success / spell
            # find the first element in potions that >= target
            left = 0
            right = m
            while left < right:
                mid = (left + right) // 2
                if potions[mid] >= target:
                    right = mid
                else:
                    left = mid + 1
            pairs[i] = m - left

        return pairs


if __name__ == '__main__':
    sol = Solution()



