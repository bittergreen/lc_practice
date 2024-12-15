# 94. 二叉树的中序遍历
from typing import Optional, List

from trees import TreeNode


class Solution:
    def inorderTraversalRecur(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        def dfs(root, res):
            if root is None:
                return
            dfs(root.left, res)
            res.append(root.val)
            dfs(root.right, res)

        dfs(root, res)
        return res

    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        stack = []
        while stack or root:
            if root:
                stack.append(root)
                root = root.left
            else:
                tmp = stack.pop()
                res.append(tmp.val)
                root = tmp.right
        return res
