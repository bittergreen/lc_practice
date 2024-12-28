# 1372. 二叉树中的最长交错路径
from typing import Optional

from trees import TreeNode


class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:

        self.max_length = 0

        # True => last direction was left; False => last direction was right
        def dfs(node, was_left: bool, cur_length):
            if node is None:
                return
            self.max_length = max(self.max_length, cur_length)
            if was_left:
                dfs(node.left, True, 1)
                dfs(node.right, False, cur_length + 1)
            else:
                dfs(node.right, False, 1)
                dfs(node.left, True, cur_length + 1)
            return

        dfs(root, True, 0)
        return self.max_length
