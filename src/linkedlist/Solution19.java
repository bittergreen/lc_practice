package linkedlist;

// 19. Remove Nth Node From End of List

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null) {
            fast = fast.next;
            if (n <= 0) {
                prev = slow;
                slow = slow.next;
            }
            n--;
        }

        // delete
        if (prev != null) {
            prev.next = slow.next;
        } else if (n == 0) {
            return head.next;
        }
        return head;

    }

}
