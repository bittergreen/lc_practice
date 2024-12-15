# 1448. 统计二叉树中好节点的数目
from typing import Optional

from trees import TreeNode


class Solution:
    def goodNodes(self, root: Optional[TreeNode]) -> int:

        if root is None:
            return 0

        self.num = 0

        def dfs(node, max_value):
            if node is None:
                return
            value = node.val
            if value >= max_value:
                self.num += 1
            # dfs
            dfs(node.left, max(value, max_value))
            dfs(node.right, max(value, max_value))
            return

        dfs(root, root.val - 1)
        return self.num
