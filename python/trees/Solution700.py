# 700. 二叉搜索树中的搜索
from typing import Optional

from trees import TreeNode


class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        node = root
        while node:
            if node.val == val:
                return node
            elif node.val > val:
                node = node.left
            else:
                node = node.right
        return None
