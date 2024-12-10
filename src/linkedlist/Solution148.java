package linkedlist;

import java.util.ArrayList;
import java.util.List;

// 148. Sort List
public class Solution148 {
    public ListNode sortList(ListNode head) {

        List<ListNode> lst = new ArrayList<>();
        ListNode now = head;
        while (now != null) {
            lst.add(now);
            now = now.next;
        }
        return head;

    }

    void merge() {

    }

    public static void main(String[] args) {
        Solution148 s = new Solution148();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        s.sortList(head);
    }
}
