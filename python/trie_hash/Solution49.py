# 49. 字母异位词分组
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        tool = {}
        for s in strs:
            key = ''.join(sorted(s))
            if key in tool:
                tool[key].append(s)
            else:
                tool[key] = [s]
        return list(tool.values())

