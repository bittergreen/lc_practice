# 2. 两数相加
from typing import Optional

from linked_list import ListNode


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        res_head = ListNode()
        res = res_head
        while l1 and l2:
            s = l1.val + l2.val + carry
            carry = 0
            if s >= 10:
                s = s % 10
                carry = 1
            res.next = ListNode(s)
            res = res.next
            l1 = l1.next
            l2 = l2.next
        # should consider carry
        while l1:
            s = l1.val + carry
            carry = 0
            if s >= 10:
                s = s % 10
                carry = 1
            res.next = ListNode(s)
            res = res.next
            l1 = l1.next
        while l2:
            s = l2.val + carry
            carry = 0
            if s >= 10:
                s = s % 10
                carry = 1
            res.next = ListNode(s)
            res = res.next
            l2 = l2.next
        if carry == 1:
            res.next = ListNode(1)
        return res_head.next
