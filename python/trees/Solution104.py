# 104. 二叉树的最大深度
from typing import Optional

from trees import TreeNode


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

    def maxDepthPreOrderWithStack(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        stack = [(root, 1)]
        max_depth = 0
        while stack:
            node, depth = stack.pop()
            if node:
                max_depth = max(max_depth, depth)
                if node.right:
                    stack.append((node.right, depth + 1))
                if node.left:
                    stack.append((node.left, depth + 1))
