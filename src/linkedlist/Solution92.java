package linkedlist;// 92. 反转链表 II


public class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        ListNode now = head;
        ListNode last = null;
        int pos = 1;

        // run to node before left
        while (pos < left) {
            last = now;
            now = now.next;
            pos++;
        }

        // node = left
        ListNode outerEnd = last;
        ListNode innerEnd = now;
        last = now;
        now = now.next;
        pos++;

        // between left - right, do reverse
        while (pos < right) {
            ListNode tmp = now.next;
            now.next = last;
            last = now;
            now = tmp;
            pos++;
        }

        // node = right, do link
        ListNode tmp = now.next;
        now.next = last;
        if (outerEnd != null) {
            outerEnd.next = now;
        } else {
            head = now;
        }
        innerEnd.next = tmp;


        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
/*        linkedlist.ListNode now = head;
        now.next = new linkedlist.ListNode(5);*/
//        now = now.next;
//        now.next = new linkedlist.ListNode(3);
//        now = now.next;
//        now.next = new linkedlist.ListNode(4);
//        now = now.next;
//        now.next = new linkedlist.ListNode(5);

        int left = 1;
        int right = 1;
        Solution92 sol = new Solution92();
        ListNode res = sol.reverseBetween(head, left, right);
        System.out.println(res);

    }
}
