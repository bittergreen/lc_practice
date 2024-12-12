# 234. 回文链表
from typing import Optional

from linked_list import ListNode


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return False
        if head.next is None:
            return True

        res = True
        # use fast-slow pointers to find the middle node, meanwhile flipping the first half of the linkedlist
        slow = head
        fast = head
        slow_last = None
        while fast and fast.next:
            fast = fast.next.next
            tmp = slow.next
            slow.next = slow_last
            slow_last = slow
            slow = tmp
        # if fast is None, we have 2x nodes, slow is the 3th out of 4, slow_last is the 2th out of 4
        # if fast.next is None, we have 2x+1 nodes, slow is the mid, slow_last is the mid - 1 guy
        if fast is not None:
            slow = slow.next
        # check if the 2 parts are equal
        while slow and slow_last:
            # note: .val!!!
            if slow.val != slow_last.val:
                res = False
                break
            else:
                slow = slow.next
                slow_last = slow_last.next
        return res

