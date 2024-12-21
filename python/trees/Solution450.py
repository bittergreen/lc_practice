# 450. 删除二叉搜索树中的节点
from typing import Optional

from trees import TreeNode


class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if root is None:
            return None
        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            if root.left is None and root.right is None:
                return None
            elif root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            else:
                # find node with min value from the right subtree
                min_val_right = self.findMin(root.right)
                root.val = min_val_right
                root.right = self.deleteNode(root.right, min_val_right)
        return root

    def findMin(self, node: TreeNode):
        while node.left:
            node = node.left
        return node.val
