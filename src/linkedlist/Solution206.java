package linkedlist;// 206. 反转链表


public class Solution206 {

    public ListNode reverseList(ListNode head) {

        ListNode last = null;
        ListNode now = head;

        while (now != null) {
            ListNode tmp = now.next;
            now.next = last;
            last = now;
            now = tmp;
        }

        return last;

    }

}
