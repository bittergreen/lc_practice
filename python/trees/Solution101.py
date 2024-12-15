# 101. 对称二叉树
from typing import Optional

from trees import TreeNode


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return root is None or self.recur(root.left, root.right)

    def recur(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        if left.val != right.val:
            return False
        return self.recur(left.left, right.right) and self.recur(left.right, right.left)

