# 328. 奇偶链表
from typing import Optional

from linked_list import ListNode


class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        head_odd = ListNode()
        head_even = ListNode()
        odd = head_odd
        even = head_even
        while head:
            odd.next = head
            odd = head
            head = head.next
            if head:
                even.next = head
                even = head
                head = head.next
        odd.next = head_even.next
        even.next = None
        return head_odd.next
