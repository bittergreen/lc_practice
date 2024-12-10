package linkedlist;

// 21. Merge Two Sorted Lists
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode();
        ListNode tmp = new ListNode();
        res.next = tmp;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tmp.next = list1;
                tmp = tmp.next;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                tmp = tmp.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) tmp.next = list1;
        if (list2 != null) tmp.next = list2;
        return res.next.next;
    }
}
