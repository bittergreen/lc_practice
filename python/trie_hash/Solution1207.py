# 1207. 独一无二的出现次数
from typing import List


class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        sup_dict = {}
        for num in arr:
            if num not in sup_dict:
                sup_dict[num] = 1
            else:
                sup_dict[num] += 1
        results = sup_dict.values()
        return len(results) == len(set(results))
