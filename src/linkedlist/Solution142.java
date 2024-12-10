package linkedlist;

import java.util.HashSet;

// 142. Linked List Cycle II
public class Solution142 {

    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            set.add(slow);
            slow = slow.next;
            if (set.contains(fast.next)) return fast.next;
            if (set.contains(fast.next.next)) return fast.next.next;
            fast = fast.next.next;
        }

        return null;
    }
}
