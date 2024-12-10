package linkedlist;

// 160. Intersection of Two Linked Lists


import java.util.ArrayList;
import java.util.List;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // break
        if (headA == null || headB == null) return null;
        List<ListNode> a = new ArrayList<>();
        List<ListNode> b = new ArrayList<>();

        int indexA = 0;
        int indexB = 0;

        // find the last node of A
        while (headA.next != null) {
            a.add(headA);
            headA = headA.next;
            indexA++;
        }

        // try to find node in B that equals last of A
        while (headB != null && headB != headA) {
            b.add(headB);
            headB = headB.next;
            indexB++;
        }

        if (headB == null) return null;

        // backtrack to the node where A != B
        while (headA == headB) {
            if (indexA == 0) return headA;
            if (indexB == 0) return headB;
            indexA--;
            headA = a.get(indexA);
            indexB--;
            headB = b.get(indexB);
        }

        return headA.next;

    }
}
