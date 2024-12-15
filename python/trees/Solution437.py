# 437. 路径总和 III
from typing import Optional

from trees import TreeNode


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:

        if root is None:
            return 0

        self.res = 0
        # prefixSum: how many times it appears
        self.presum_hash = {0: 1}

        def dfs(node, presum):
            if node is None:
                return
            presum += node.val
            # want to find presum[i] of presum[j] - targetSum
            key = presum - targetSum
            self.res += self.presum_hash.get(key, 0)
            # add this prefix sum to the hashtable
            self.presum_hash[presum] = self.presum_hash.get(presum, 0) + 1
            if node.left is not None:
                dfs(node.left, presum)
            if node.right is not None:
                dfs(node.right, presum)
            # minus 1 before return
            self.presum_hash[presum] = self.presum_hash.get(presum, 0) - 1
            return

        dfs(root, 0)
        return self.res

