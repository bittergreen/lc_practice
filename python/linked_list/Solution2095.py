# 2095. 删除链表的中间节点
from typing import Optional

from linked_list import ListNode


class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        if head.next is None:
            return None
        # start from length 2
        prev = None
        slow = head
        fast = head
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        # for 2n nodes, fast is None, slow is the n+1-th node, need to delete slow itself;
        # for 2n+1 nodes, fast.next is None, slow is the n-th node, also need to delete slow itself.
        prev.next = slow.next
        return head

