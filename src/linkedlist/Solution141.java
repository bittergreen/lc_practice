package linkedlist;// 141. 环形链表

public class Solution141 {
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        boolean has = false;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (slow == fast) {
                has = true;
                break;
            }
            slow = slow.next;
        }

        return has;

    }
}
