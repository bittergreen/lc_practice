# 142. 环形链表 II
from typing import Optional

from linked_list import ListNode


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        detect = set()
        fast = head
        slow = head
        while fast and fast.next:
            detect.add(slow)
            slow = slow.next
            if fast.next in detect:
                return fast.next
            if fast.next.next in detect:
                return fast.next.next
            fast = fast.next.next
        return None
