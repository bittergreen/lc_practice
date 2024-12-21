# 1161. 最大层内元素和
from collections import deque
from typing import Optional

from trees import TreeNode


def maxLevelSum(self, root: Optional[TreeNode]) -> int:
    if not root:
        return 0
    level_index = 1
    max_sum = float('-inf')
    res = 0
    queue = deque([root])
    while queue:
        level_sum = 0
        for _ in range(len(queue)):
            node = queue.popleft()
            level_sum += node.val
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        if level_sum > max_sum:
            res = level_index
            max_sum = level_sum
        level_index += 1
    return res
