# 2300. 咒语和药水的成功对数
from typing import List


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions = sorted(potions)
        pairs = [0] * len(spells)
        # spell * potion >= success
        for i, spell in enumerate(spells):
            left = 0
            right = len(potions) - 1
            while left <= right:
                mid = (left + right) // 2
                if spell * potions[mid] >= success:
                    right = mid - 1
                else:
                    left = mid + 1
            pairs[i] = len(potions) - left
        return pairs


if __name__ == '__main__':
    sol = Solution()



