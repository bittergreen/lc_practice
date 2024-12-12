# 2130. 链表最大孪生和
from typing import Optional

from linked_list import ListNode


class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        if head is None:
            return 0
        fast = head
        slow = head
        prev = None
        while fast and fast.next:
            fast = fast.next.next
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp
        # fast is None, total 2n, slow is the n+1-th, prev is the n-th
        maxNum = 0
        while slow and prev:
            maxNum = max(maxNum, slow.val+prev.val)
            slow = slow.next
            prev = prev.next
        return maxNum