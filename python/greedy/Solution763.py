# 763. 划分字母区间
from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_index = {char: i for i, char in enumerate(s)}
        start, end = 0, 0
        res = []
        for i, char in enumerate(s):
            end = max(end, last_index[char])
            if end == i:
                # length of current partition
                length = end - start + 1
                start = end + 1
                res.append(length)
        return res
