# 560. 和为 K 的子数组
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # find (presum[j] - presum[i]) = k, where j > i
        # use hashtable to store the presum values we got
        res = 0
        presum = 0
        presum_hash = {0: 1}
        for num in nums:
            presum += num
            # the presum[i] we want to find
            key = presum - k
            if key in presum_hash:
                res += presum_hash[key]
            presum_hash[presum] = presum_hash.get(presum, 0) + 1
        return res
