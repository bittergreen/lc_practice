# 226. 翻转二叉树
from collections import deque
from typing import Optional

from trees import TreeNode


class Solution:
    def invertTreeLayerOrder(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return root
        queue = deque([root])
        while queue:
            level_size = len(queue)
            for _ in range(level_size):
                node = queue.popleft()
                if node.left is None and node.right is None:
                    continue
                # flip
                tmp = node.left
                node.left = node.right
                node.right = tmp
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
        return root

    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return
        tmp = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(tmp)
        return root
