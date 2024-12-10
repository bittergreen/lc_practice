package linkedlist;

// 24. Swap Nodes in Pairs
public class Solution24 {
    public ListNode swapPairs(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode prev = new ListNode();
        ListNode res = prev;
        ListNode left = head;
        ListNode right = head.next;

        while (right != null) {
            ListNode tmp = right.next;
            left.next = tmp;
            right.next = left;
            prev.next = right;

            if (tmp == null) break;
            prev = left;
            left = tmp;
            right = left.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution24 s = new Solution24();
        System.out.println(s.swapPairs(head));
    }
}
