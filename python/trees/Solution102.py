# 102. 二叉树的层序遍历
from collections import deque
from typing import Optional, List

from trees import TreeNode


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        res = []
        queue = deque([root])
        while queue:
            level_values = []
            length = len(queue)
            for _ in range(length):
                node = queue.popleft()
                level_values.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            res.append(level_values)
        return res

