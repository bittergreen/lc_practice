# 199. 二叉树的右视图
from collections import deque
from typing import Optional, List

from trees import TreeNode


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        queue = deque([root])
        res = []
        while queue:
            length = len(queue)
            for _ in range(length):
                tmp = queue.popleft()
                if tmp.left:
                    queue.append(tmp.left)
                if tmp.right:
                    queue.append(tmp.right)
            res.append(tmp.val)
        return res
