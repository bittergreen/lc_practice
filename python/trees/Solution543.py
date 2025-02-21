# 543. 二叉树的直径
from typing import Optional

from trees import TreeNode


class Solution:

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0

        def depth(node):
            if not node:
                return 0
            left_depth = depth(node.left)
            right_depth = depth(node.right)
            self.diameter = max(self.diameter, left_depth + right_depth)
            return max(left_depth, right_depth) + 1

        depth(root)
        return self.diameter
