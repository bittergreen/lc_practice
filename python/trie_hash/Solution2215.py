# 2215. 找出两数组的不同
from typing import List


class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        set1 = set(nums1)
        set2 = set(nums2)
        return [[i for i in set1 if i not in set2], [i for i in set2 if i not in set1]]
