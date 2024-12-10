package linkedlist;

// 234. Palindrome Linked List
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        // revert the first half of the linked list, and use fast/slow pointers to find the mid point
        boolean res = true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode tmp;
        ListNode slowPrev = null;

        if (fast == null) return false;
        if (fast.next == null) return true;

        // revert the first half in the same time
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tmp = slow.next;
            slow.next = slowPrev;
            slowPrev = slow;
            slow = tmp;
        }

        // if fast == null, we have 2x nodes, and slow is the 3th out of 4, slowPrev is the 2nd of 4
        // if fast.next == null, we have 2x+1 nodes, and slow is the mid guy, slowPrev is 1 before mid guy
        if (fast != null) slow = slow.next;

        while (slow != null && slowPrev != null) {
            if (slow.val != slowPrev.val) {
                res = false;
                break;
            }
            slow = slow.next;
            slowPrev = slowPrev.next;
        }

        return res;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        Solution234 s = new Solution234();
        System.out.println(s.isPalindrome(head));
    }
}
