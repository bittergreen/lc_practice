# 872. 叶子相似的树
from typing import Optional

from trees import TreeNode


class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:

        if root1 is None and root2 is None:
            return True
        if root1 is None or root2 is None:
            return False

        def dfs(root, res):
            if root.left is None and root.right is None:
                res.append(root.val)
            if root.left is not None:
                dfs(root.left, res)
            if root.right is not None:
                dfs(root.right, res)

        res1 = []
        dfs(root1, res1)
        res2 = []
        dfs(root2, res2)

        return res1 == res2

