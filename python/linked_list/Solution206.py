# 206. 反转链表
from typing import Optional

from linked_list import ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        last = None
        now = head
        while now is not None:
            tmp = now.next
            now.next = last
            last = now
            now = tmp
        return last

