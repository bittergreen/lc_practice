# 160. 相交链表
from typing import Optional

from linked_list.ListNode import ListNode


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None or headB is None:
            return None
        a = []
        b = []
        indexA = 0
        indexB = 0
        # find the last node of A
        while headA.next is not None:
            a.append(headA)
            headA = headA.next
            indexA += 1
        # try to find the node B that equals to the last node of A
        while headB and (headB != headA):
            b.append(headB)
            headB = headB.next
            indexB += 1
        if not headB:
            return None
        # if found, backtrack to the node where A!=B
        while headA == headB:
            if indexA == 0:
                return headA
            if indexB == 0:
                return headB
            indexA -= 1
            headA = a[indexA]
            indexB -= 1
            headB = b[indexB]

        return headA.next


