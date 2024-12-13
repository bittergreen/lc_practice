# 724. 寻找数组的中心下标
from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        prefix_sum = [0] * (len(nums)+1)
        prefix_sum[0] = 0
        for i in range(0, len(nums)):
            prefix_sum[i+1] = prefix_sum[i] + nums[i]
        total_sum = prefix_sum[-1]

        res = -1
        for i in range(len(prefix_sum)-1):
            if prefix_sum[i] == total_sum - prefix_sum[i] - nums[i]:
                res = i
                return res
        return res


if __name__ == '__main__':
    sol = Solution()
    print(sol.pivotIndex([1,7,3,6,5,6]))
