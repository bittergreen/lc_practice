package linkedlist;

// 2. 两数相加
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int value;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            value = a + b + carry;
            carry = value >= 10 ? 1 : 0;
            value = value % 10;
            cur.next = new ListNode(value);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(1);
        }

        return pre.next;

    }


}
